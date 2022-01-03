package com.jiyeon.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests( requests -> {
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) requests.antMatchers("/auth")).authenticated();
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) requests.antMatchers("/main")).permitAll();
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) requests.antMatchers("/non-auth")).permitAll();
        });

        /**
         * authenticated();
         * permitAll();
         * anyRequest();
         * denyAll();
         */

        http.formLogin();
        http.httpBasic();

    }
    
}
