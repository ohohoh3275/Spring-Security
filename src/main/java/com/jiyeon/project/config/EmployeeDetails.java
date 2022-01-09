package com.jiyeon.project.config;


import com.jiyeon.project.model.Employee;
import com.jiyeon.project.model.EmployeeSecurity;
import com.jiyeon.project.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeDetails implements UserDetailsService {


    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Employee> employees = employeeRepository.findByName(s);
        if(!employees.isPresent()){
            throw new UsernameNotFoundException("employee is not present");
        }

        return new EmployeeSecurity(employees.get());
    }
}
