package com.example.demo.employee.repository;

import com.example.demo.employee.entity.Leave;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaveRepository extends CrudRepository<Leave,Long> {
    @Override
    Iterable<Leave> findAll();

    @Override
    Optional<Leave> findById(Long aLong);
}






//    This interface consider to do every operation on database