package com.jiyeon.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

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


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //configure default user
        //like i did at application.properties

        auth.inMemoryAuthentication()
                .withUser("user-name")
                .password("123123")
                .authorities("admin")
                .and()
                .withUser("user")
                .password("12")
                .authorities("read")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());

    }

}
