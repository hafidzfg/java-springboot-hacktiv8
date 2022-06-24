package com.assignment.api.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assignment.api.model.Product;
import com.assignment.api.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	@Autowired
	ProductService productService;

	// tag untuk enable cross origin
	@CrossOrigin
	@GetMapping("/products") // tag bikin endpoint get
	public List<Product> list() {
		return productService.listAllProduct();
	}

	@CrossOrigin
	@GetMapping("/products/{id}") // tag bikin endpoint get
	public ResponseEntity<Product> products(@PathVariable Integer id) {
		try {
			Product product = productService.getProduct(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@PostMapping("/products") // tag endpoint post
	public ResponseEntity<?> products(@RequestBody Product product) {
		productService.saveProduct(product);
		return new ResponseEntity<>("Produk tersimpan!", HttpStatus.CREATED);
	}

	@CrossOrigin
	@PutMapping("/products/{id}") // tag endpoint put
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
		try {
			Product existUser = productService.getProduct(id);
			if (existUser.getId() != id) {
				return new ResponseEntity<>("ID Tidak Ada !!", HttpStatus.OK);
			}
			product.setId(id);
			productService.saveProduct(product);
			return new ResponseEntity<>("Produk terupdate!", HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Produk nggk ketemu!", HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			productService.deleteProduct(id);
			return new ResponseEntity<>("Produk dihapus!",HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Produk yang mau dihapus nggk ketemu!", HttpStatus.NOT_FOUND);
		}
	}

}
