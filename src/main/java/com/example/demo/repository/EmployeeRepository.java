package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    Employee findByNom(String name);

    @Override
    Iterable<Employee> findAll();

    @Override
    Optional<Employee> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
