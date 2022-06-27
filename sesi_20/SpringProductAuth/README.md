# Unit Testing & Basic Authentication

Project ini berisi penerapan Basic Authentication pada Springboot dan Unit Testing. <br>
Pastikan anda sudah membuat database bernama `assignment3`

## Unit Testing

Unit testing adalah pengujian/testing dari bagian terkecil sebuah program yang bisa ditest. Unit testing digunakan untuk menjamin jika program yang kita buat berfungsi pada level pemrograman.

Pada project ini, terdapat dua class dimana kita definisikan unit test yang kita buat untuk mengecek fungsi yang berhubungan dengan product:

1. TestObjectFactory <br>
   Class ini berisi logika yang berfungsi untuk membuat product dummy yang akan digunakan pada unit test.
2. ProductServiceTest <br>
   Class ini berisi unit test yang kita buat seputar product:

```
@RunWith(SpringRunner.class)
public class ProductServiceTest {

	// membuat mock object productService
	@InjectMocks
	private ProductService productService = new ProductServiceImpl();

	// membuat mock object productRepository
	@Mock
	private ProductRepository productRepository;


	// suppress warning karena kita memakai Spring 2.4.2
	@SuppressWarnings("deprecation")
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
```

- Untuk menjalankan unit test, masuk terlebih dahulu ke folder project: `cd SpringProductAuth`
- Lalu jalankan unit test product: `mvn test -Dtest=ProductServiceTest`

## Basic Authentication

Pada project ini juga dilakukan penerapan otentikasi pada Spring boot.

1. Jalankan aplikasi: `mvn spring-boot:run` <br>
   Program akan menghapus isi dari tabel `user` pada database `assignment3`, kemudian ia akan membuat dua user yakni:

- user: admin, password: admin123
- user: manager, password: manager123 <br>
  Kode penghapusan dan pembuatan isi tabel ini tedapat pada service `UserServiceInit`

2. Akses endpoint:

- GET `/api/management/` untuk menampilkan semua user yang baru saja dibuat.
- GET `/api/management/test1` dengan Basic Auth: user dan password `manager:manager123` atau `admin:admin123`. Endpoint ini hanya bisa diakses dengan otentikasi user manager atau admin.
- GET `/api/management/test2` dengan Basic Auth: user dan password `manager:manager123` atau `admin:admin123`. Endpoint ini hanya bisa diakses dengan otentikasi user manager atau admin.
- GET `/api/profile/test1` dengan salah satu dari user di atas (admin/manager)
- GET `/api/user/test1` dengan salah satu dari user di atas (admin/manager)
- GET `/api/user/test2` hanya dengan `admin:admin123`

Terdapat pula endpoint product yang hanya dapat diakses dengan user:password `admin:admin123`, yakni:

- POST `/api/products`, masukkan body dalam format application/json untuk key "nama", "hargaBeli", dan "hargaJual".
- GET `/api/products`, akan menampilkan semua produk yang terdapat dalam tabel
- GET `/api/products/:id`, masukkan nomor id, endpoint ini akan menampilkan data produk dari id yang diberikan.
- PUT `/api/products/:id`, masukkan nomor id pada endpoint, masukkan "name", "hargaBeli", dan "hargaJual" pada body request. Endpoint ini akan mengupdate data dari produk dengan id yang diberikan.
- DELETE `/api/products/:id`, masukkan id pada endpoint, data produk dengan id yang diberikan akan dihapus dari tabel.
