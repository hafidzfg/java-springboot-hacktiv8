package com.demo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAllByName(String nama);

	void deleteById(Long id);


}
