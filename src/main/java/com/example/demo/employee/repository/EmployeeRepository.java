package com.example.demo.employee.repository;

import com.example.demo.employee.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Member,Long> {
    Member findByNom(String name);

    @Override
    Iterable<Member> findAll();

    @Override
    Optional<Member> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
