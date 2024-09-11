package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}

