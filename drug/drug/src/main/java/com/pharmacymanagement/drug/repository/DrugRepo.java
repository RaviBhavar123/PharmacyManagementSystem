package com.pharmacymanagement.drug.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pharmacymanagement.drug.entity.Drug;

public interface DrugRepo extends MongoRepository<Drug, Long>{

}
