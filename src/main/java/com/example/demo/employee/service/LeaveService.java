package com.example.demo.employee.service;

import com.example.demo.employee.entity.Leave;
import com.example.demo.employee.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepository repository;

    public Optional<Leave> findById(Long id){
        return repository.findById(id);
    }

    public Leave save(Leave leave){
        return repository.save(leave);
    }
    public Iterable<Leave> findAllLeave(){
        return repository.findAll();
    }

}


// this class is do the save operation in database for leave

//this class