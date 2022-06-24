package com.assignment.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
