package com.varnaa.bookdate.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.varnaa.bookdate.BackendApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {
    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger(BackendApplication.class);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
