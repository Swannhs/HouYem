package com.example.demo.employee.service;

import com.example.demo.employee.entity.Member;
import com.example.demo.employee.entity.Role;
import com.example.demo.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberService {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Member saveAdmin(Member member) {
        member.setPassword(encoder.encode(member.getPassword()));
        member.setRoles(Arrays.asList(new Role("ADMIN")));
        return repository.save(member);
    }


    public Member save(Member member) {
        member.setPassword(encoder.encode(member.getPassword()));
        member.setRoles(Arrays.asList(new Role("EMPLOYEE")));
        return repository.save(member);
    }

    public Iterable<Member> findAllEmployees(){
        return repository.findAll();
    }

    public Optional<Member> findById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Member findByName(String name){
        Member member = repository.findByNom(name);
        return member;
    }
}

// this method will authorize employee username and password ok