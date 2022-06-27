package com.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.demo.api.model.Product;

public class TestObjectFactory {
	// untuk dipakai oleh unit test guna menggenerate object product dummy
	public static Product createProduct() {
		// membuat object product baru
		final Product product = new Product();
		
		// mengeset id dari object product dengan id yang dirandomize
		product.setId(new Random().nextLong());
		
		// mengeset nama dari product dengan nama yang dirandomize
		product.setName(RandomStringUtils.randomAlphabetic(10));
		
		// mengeset hargaBeli dari product dengan hargaBeli yang dirandomize
		product.setHargaBeli(new Random().nextLong());
		
		// mengeset hargaJual dari product dengan hargaJual yang dirandomize
		product.setHargaJual(new Random().nextLong());

		return product;
	}

	// membuat object list dari product
	public static List<Product> createProductList(final int size) {
		final List<Product> result = new ArrayList<>();
		
		// membuat loop untuk generate beberapa product dummy, 
		// tiap iterasi memanggil object createProduct() yang dibuat di atas
		for (int i = 0; i < size; i++) {
			result.add(createProduct());
		}
		return result;
	}

}
