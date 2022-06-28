package com.demo.api;

import static org.mockito.Mockito.times;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import com.demo.api.model.Product;
import com.demo.api.repository.ProductRepository;
import com.demo.api.service.ProductService;
import com.demo.api.service.impl.ProductServiceImpl;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

	// membuat mock object productService
	@InjectMocks
	private ProductService productService = new ProductServiceImpl();

	// membuat mock object productRepository
	@Mock
	private ProductRepository productRepository;


	// suppress warning karena kita memakai Spring 2.4.2
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(productService, "productRepository", productRepository);
	}
	
	// unit test untuk mengetest productService yang memanggil
	// fungsi yang meng-get semua product (findAllProducts)
	@Test
	public void testFindAll() {

		final List<Product> datas = TestObjectFactory.createProductList(10);
		Mockito.when(productRepository.findAll()).thenReturn(datas);

		final List<Product> actual = productService.findAllProducts();
		MatcherAssert.assertThat(actual.size(), Matchers.equalTo(datas.size()));
	}
	
	// unit test yang mengecek product by id
	@Test
	public void testProductById() throws Exception {

		// randomize id product
		final Long id = new Random().nextLong();
		
		// buat product dengan memanggil object dari TestObjectFactory
		final Product product = TestObjectFactory.createProduct();
		
		// mengetest findById dan jika null mereturn alternatif yang
		// didefinisikan dalam ProductServiceImpl yakni membuat new Product()
		Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(product));

		// dari product yang ketemu atau dibuat sebelumnya, didefinisikan di
		// dalam object actual
		final Product actual = productService.findProductById(id);
		
		// cek apakah tiap field actual dengan product yang dicari/dibuat sebelumnya sama
		MatcherAssert.assertThat(actual.getId(), Matchers.equalTo(product.getId()));
		MatcherAssert.assertThat(actual.getName(), Matchers.equalTo(product.getName()));
		MatcherAssert.assertThat(actual.getHargaBeli(), Matchers.equalTo(product.getHargaBeli()));
		MatcherAssert.assertThat(actual.getHargaJual(), Matchers.equalTo(product.getHargaJual()));
	}
	
	// unit test yang mengecek product by id
	@Test
	public void testProductByIdWithNullDataFromDB() throws Exception {
		final Long id = new Random().nextLong();

		Mockito.when(productRepository.findById(id)).thenReturn(Optional.empty());
		final Product actual = productService.findProductById(id);
		MatcherAssert.assertThat(actual, Matchers.notNullValue());
	}
	
	// unit test yang mengecek pembuatan product atau update product
	@Test
	public void testSaveUpdateProduct() {
		final Product product = TestObjectFactory.createProduct();
		Mockito.when(productRepository.save(product)).thenReturn(product);

		final Product actual = productService.saveProduct(product);
		MatcherAssert.assertThat(actual, Matchers.notNullValue());
	}

	// unit test yang mengecek menghapus sebuah product by id
	@Test
	public void testDeleteProduct() {
		final Long id = new Random().nextLong();
		Product product = TestObjectFactory.createProduct();

		Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(product));
		Mockito.doNothing().when(productRepository).delete(product);
		productService.deleteProductById(id);

		Mockito.verify(productRepository, times(1)).delete(product);
	}




}

