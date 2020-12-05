package com.alg3.alg3project.repository;

import com.alg3.alg3project.domain.RentalAgency;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalAgencyRepository extends MongoRepository<RentalAgency, String>{
    
}