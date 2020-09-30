package com.example.demo.employee.service;

import com.example.demo.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EmployeeServiceInterface extends UserDetailsService {
    UserEntity save(UserEntity employee);
    Iterable<UserEntity> findAllEmployees();
}
