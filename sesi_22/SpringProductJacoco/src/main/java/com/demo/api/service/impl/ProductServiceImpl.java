package com.demo.api.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.api.model.Product;
import com.demo.api.repository.ProductRepository;
import com.demo.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Product> findAllProductsByName(String name) {
		// TODO Auto-generated method stub
		return productRepository.findAllByName(name);
	}

	@Override
	public Product findProductById(Long id) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id).orElse(new Product());
		return product;
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id).orElse(new Product());
		productRepository.delete(product);
	}

}
