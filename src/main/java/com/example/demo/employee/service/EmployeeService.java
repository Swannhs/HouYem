package com.example.demo.employee.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public UserEntity save(UserEntity employee) {
        employee.setPassword(encoder.encode(employee.getPassword()));
        return repository.save(employee);
    }

    public Iterable<UserEntity> findAllEmployees(){
        return repository.findAll();
    }

    public Optional<UserEntity> findById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

//    public Employee findByName(String name){
//        Employee employee = repository.findByNom(name);
//        return
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Employee employee = repository.findByNom(username);
//        if(employee == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new User(employee.getNom(), employee.getPassword(), mapRolesToAuthorities(employee.getRoles()));
//    }
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }
}

// this method will authorize employee username and password ok