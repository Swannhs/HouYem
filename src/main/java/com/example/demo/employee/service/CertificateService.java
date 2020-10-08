package com.example.demo.employee.service;

import com.example.demo.employee.entity.CertificateEntity;
import com.example.demo.employee.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {
    @Autowired
    private CertificateRepository repository;

    public CertificateEntity save(CertificateEntity entity){
        return repository.save(entity);
    }

    public Iterable<CertificateEntity> findAll(){
        return repository.findAll();
    }

    public CertificateEntity findByName(String name){
        return repository.findByName(name);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
