package com.varnaa.bookdate.filters;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author swethavarnaa
 */

@Component
public class LoggingFilter implements Filter {

    @Autowired
    private Logger logger;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("request made to the server ->" + servletRequest.getServerName());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
