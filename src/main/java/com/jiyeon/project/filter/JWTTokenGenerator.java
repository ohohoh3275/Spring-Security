package com.jiyeon.project.filter;

import org.hibernate.query.criteria.internal.ParameterContainer;
import org.hibernate.query.criteria.internal.path.MapKeyHelpers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTTokenGenerator extends OncePerRequestFilter {

    @Value("${JWT_KEY}")
    String JWT_KEY;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(null != authentication){
            SecretKey key = Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8));
            String jwt = Jwts.builder()
                    .setIssuer("JiYeon")
                    .setSubject("JWT Token")
                    .claim("username", authentication.getName())
                    .claim("authorities", getAuthorities(authentication.getAuthorities()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + 10000))
                    .signWith(key).compact();

            response.setHeader("Authorization", jwt);
        }

        filterChain.doFilter(request, response);

    }

    private String getAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
    }
}
