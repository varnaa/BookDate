package com.varnaa.bookdate.service;

import com.varnaa.bookdate.model.Plan;
import com.varnaa.bookdate.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author swethavarnaa
 */


class SubscriptionRowMapper implements RowMapper<Subscription> {
    @Override
    public Subscription mapRow(ResultSet rs, int rowNum) throws SQLException {
        Subscription subscription = new Subscription();
        Plan plan = new Plan();
        plan.setPlan_code(rs.getString("plan_code"));
        plan.setBilling_cycles(rs.getInt("billing_cycles"));
        plan.setPrice(rs.getInt("price"));
        plan.setQuantity(rs.getInt("quantity"));

        subscription.setPlan(plan);
        subscription.setStatus(rs.getString("status"));
        subscription.setExpiresAt(rs.getString("expires_at"));
        subscription.setCustomerId(rs.getString("customer_id"));
        subscription.setActivatedAt(rs.getString("activated_at"));
        subscription.setNextBillingAt(rs.getString("next_billing_at"));
        subscription.setLastBillingAt(rs.getString("last_billing_at"));
        subscription.setSubscriptionId(rs.getString("subscription_id"));

        return subscription;
    }
}

@Component
public class CustomViewService {


    private final HashMap<String, String> comparators;
    private final HashMap<String, String> filters;
    @Autowired
    JdbcTemplate db;

    public CustomViewService() {
        this.comparators = initializeComparators();
        this.filters = initializeFilters();
    }

    public List<Subscription> filterSubscription(Map<String, String> queryParameters) {
        String generatedQuery = createQuery(queryParameters.get("attributeName"),
                                            queryParameters.get("comparator"),
                                            queryParameters.get("filterType"));
        return fetchSubscription(generatedQuery);
    }

    private List<Subscription> fetchSubscription(String query) {
        List<Subscription> subscriptionList = db.query(query, new SubscriptionRowMapper());
        System.out.println(subscriptionList);
        return subscriptionList;
    }


    private String createQuery(String attributeName, String comparator, String filterType) {
        StringBuilder query = new StringBuilder("SELECT * FROM subscription left join plan p on subscription.id = p.id WHERE ");

        // step 1: append the attribute
        if (filterType.contentEquals("nextWeek") ||
                filterType.contentEquals("previousWeek")) {
            query.append("week(").append(attributeName).append(")");
        } else if (filterType.contentEquals("thisMonth") ||
                filterType.contentEquals("nextMonth") ||
                filterType.contentEquals("previousMonth")) {
            query.append(getSqlLogicForMonth(attributeName, filterType, comparator));
            System.out.println(query);
            return query.toString();
        } else {
            query.append(attributeName);
        }

        // step 2: append the comparatpr
        query.append(comparators.get(comparator));

        // step 3: Append the value to compare
        query.append(filters.get(filterType));

        System.out.println(query);
        return query.toString();
    }

    private HashMap<String, String> initializeComparators() {
        return new HashMap<>() {{
            put("is", "=");
            put("before", "<=");
            put("after", ">=");
        }};
    }

    private HashMap<String, String> initializeFilters() {
        return new HashMap<>() {{
            put("today", "curdate()");
            put("tomorrow", "adddate(curdate(), INTERVAL 1 DAY)");
            put("yesterday", "date_sub(curdate(), INTERVAL 1 DAY)");
            put("startingDateOfWeek", "date_sub(curdate(), INTERVAL (DAYOFWEEK(curdate()) - 1) DAY)");
            put("endingDateOfWeek", "date_add(curdate(),INTERVAL (7 - DAYOFWEEK(curdate())) DAY)");
            put("nextWeek", "(week(curdate()) + 1)");
            put("nextWeekStartingDate", "date_add(curdate(), INTERVAL (7-DAYOFWEEK(curdate()) + 1) DAY)");
            put("nextWeekEndingDate", "date_add(curdate(), INTERVAL (7 - DAYOFWEEK(curdate())) + 7 DAY)");
            put("previousWeek", "week(curdate()) - 1");
            put("previousWeekStartingDate", "date_sub(curdate(), INTERVAL (DAYOFWEEK(curdate()) - 1) + 7 DAY)");
            put("previousWeekEndingDate", "date_sub(curdate(), INTERVAL (DAYOFWEEK(curdate()) DAY)");
            put("startingDateOfMonth", "last_day(curdate() - INTERVAL 1 MONTH) + 1 INTERVAL DAY)");
            put("endingDateOfMonth", "last_day(curdate())");
            put("nextMonthStartingDate", "last_day(curdate()) + INTERVAL 1 DAY)");
            put("nextMonthEndingDate", "last_day(curdate() + INTERVAL 1 MONTH) ");
            put("previousMonthStartingDate", "last_day(curdate() - INTERVAL 2 MONTH) + 1 INTERVAL DAY)");
            put("previousMonthEndingDate", "last_day(curdate() - INTERVAL 1 MONTH)");
        }};
    }

    private String getSqlLogicForMonth(String attributeName, String filterType, String comparator) {
        String operator = comparators.get(comparator);
        if (filterType.equals("thisMonth")) {
            return "MONTH(" + attributeName + ")" + operator + "MONTH(curdate()) and YEAR(curdate())" + operator + "YEAR(" + attributeName + ")";
        } else if (filterType.equals("nextMonth")) {
            return "MONTH(" + attributeName + ")" + operator + "MONTH(curdate()) + 1 and YEAR(curdate())" + operator + "YEAR(" + attributeName + ")";
        } else {
            return "MONTH(" + attributeName + ")" + operator + "MONTH(curdate()) - 1 and YEAR(curdate())" + operator + "YEAR(" + attributeName + ")";
        }
    }
}

