package com.rafif.microservices.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rafif.microservices.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}