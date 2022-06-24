# Assignment Restful API

Project ini berisi penerapan Restful API. <br>
Pastikan anda sudah membuat database bernama `assignment3`

1. Jalankan aplikasi: `mvn spring-boot:run`
2. Akses endpoint:

- POST `/api/v1/products`, masukkan body dalam format application/json untuk key "nama", "hargaBeli", dan "hargaJual".
- GET `/api/v1/products`, akan menampilkan semua produk yang terdapat dalam tabel
- GET `/api/v1/products/:id`, masukkan nomor id, endpoint ini akan menampilkan data produk dari id yang diberikan.
- PUT `/api/v1/products/:id`, masukkan nomor id pada endpoint, masukkan "name", "hargaBeli", dan "hargaJual" pada body request. Endpoint ini akan mengupdate data dari produk dengan id yang diberikan.
- DELETE `/api/v1/products/:id`, masukkan id pada endpoint, data produk dengan id yang diberikan akan dihapus dari tabel.
