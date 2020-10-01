package com.example.demo.employee.service;

import com.example.demo.employee.entity.Member;
import com.example.demo.employee.entity.MemberDetails;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

public class EmployeeServiceInterface implements UserDetailsService {

    @Autowired
    private EmployeeRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Member user = userRepository.findByNom(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MemberDetails(user);
    }

}