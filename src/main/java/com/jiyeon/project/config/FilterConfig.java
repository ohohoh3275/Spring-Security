package com.jiyeon.project.config;

import com.jiyeon.project.jwt.AuthoritiesLoggingAfterFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<AuthoritiesLoggingAfterFilter> filter(){
        FilterRegistrationBean<AuthoritiesLoggingAfterFilter> bean = new FilterRegistrationBean<>(new AuthoritiesLoggingAfterFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(0); // lower number, run first among filters
        return bean;
    }
}
