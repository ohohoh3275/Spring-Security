package com.jiyeon.project.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import javax.sql.DataSource;
import java.util.Collections;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final Oauth2UserService oauth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.cors().configurationSource(request -> {
//            CorsConfiguration config = new CorsConfiguration();
//            config.setAllowedOrigins(Collections.singletonList("http://localhost:3300"));
//            config.setAllowedMethods(Collections.singletonList("*"));
//            config.setAllowCredentials(true);
//            config.setAllowedHeaders(Collections.singletonList("*"));
//            config.setMaxAge(3600L);
//            return config;
//        }).and().
//        csrf().ignoringAntMatchers("/non-auth/**").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().
        http.
        authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/**").permitAll()
                .antMatchers("/non-auth/**").permitAll()
                .antMatchers("/admin/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/auth/login") // check the path out !
                .defaultSuccessUrl("/")
                .and()
                .oauth2Login()
                .loginPage("/login") // when google login completed, needed to be afterward works ->with token && profiles
                .userInfoEndpoint()
                .userService(oauth2UserService);


        /**
         * authenticated();
         * permitAll();
         * anyRequest();
         * denyAll();
         */


    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        //configure default user
//        //like i did at application.properties
//
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//
//        UserDetails admin = User.withUsername(userDetailsService.).password("9999").authorities("admin").build();
//        UserDetails user = User.withUsername("user").password("12345").authorities("read").build();
//
//        userDetailsService.createUser(admin);
//        userDetailsService.createUser(user);
//
//        auth.userDetailsService(userDetailsService);
//    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
