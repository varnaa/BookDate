package com.varnaa.bookdate.service;

import com.varnaa.bookdate.model.Plan;
import com.varnaa.bookdate.model.Subscription;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author swethavarnaa
 */


public class SubscriptionRowMapper implements RowMapper<Subscription> {
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