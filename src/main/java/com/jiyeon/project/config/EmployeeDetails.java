package com.jiyeon.project.config;


import com.jiyeon.project.entity.Employee;
import com.jiyeon.project.entity.EmployeeSecurity;
import com.jiyeon.project.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeDetails implements UserDetailsService, OAuth2User {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Employee> employees = employeeRepository.findByUsername(username);

        if(!employees.isPresent()){
            throw new UsernameNotFoundException("employee is not present");
        }

        Employee employee = employees.get();
        return new EmployeeSecurity(employee);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
