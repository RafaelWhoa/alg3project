package com.alg3.alg3project.repository;

import com.alg3.alg3project.domain.Vehicle;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String>{
    
}
