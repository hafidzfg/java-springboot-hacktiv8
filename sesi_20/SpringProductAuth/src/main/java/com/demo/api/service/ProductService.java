package com.demo.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.demo.api.model.Product;

@Service
@Transactional
public interface ProductService {
	List<Product> findAllProducts();

	List<Product> findAllProductsByName(String name);
	

	Product findProductById(Long id);

	Product saveProduct(Product product);

	void deleteProductById(Long id);

}
