package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
    UserEntity findByNom(String name);

    @Override
    Iterable<UserEntity> findAll();

    @Override
    Optional<UserEntity> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
