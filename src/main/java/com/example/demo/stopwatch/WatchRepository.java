package com.example.demo.stopwatch;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchRepository extends CrudRepository<WatchEntity,Long> {

}
