package com.jiyeon.project.config;

import com.jiyeon.project.jwt.AuthoritiesLoggingAfterFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    //여기 필터는 시큐리티 필터보다 늦게 실행된다-> 필터 실행순서 참고할것
    @Bean
    public FilterRegistrationBean<AuthoritiesLoggingAfterFilter> filter(){
        FilterRegistrationBean<AuthoritiesLoggingAfterFilter> bean = new FilterRegistrationBean<>(new AuthoritiesLoggingAfterFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(0); // lower number, run first among filters
        return bean;
    }
}
