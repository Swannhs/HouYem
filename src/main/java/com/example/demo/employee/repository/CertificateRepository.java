package com.example.demo.employee.repository;

import com.example.demo.employee.entity.CertificateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends CrudRepository<CertificateEntity,Long> {
    CertificateEntity findByName(String name);

    @Override
    Iterable<CertificateEntity> findAll();

}
