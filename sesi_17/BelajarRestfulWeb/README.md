# Restful Web Services & API

Pastikan anda telah membuat database bernama `h8_users`

## Mengakses Restful Web

1. Jalankan aplikasi: `mvn spring-boot:run`
2. Akses endpoint: <br>
   GET `http://localhost:8080/belajar-api/v1/get`

## Mengakses Restful APIs

1. Jalankan aplikasi: `mvn spring-boot:run`
2. Akses endpoint:

- POST `/api/v1/users`, masukkan body dalam format application/json untuk key "firstName" dan "lastName"
- GET `/api/v1/users`, akan menampilkan semua user yang terdapat dalam tabel
- GET `/api/v1/users/:id`, masukkan nomor id, endpoint ini akan menampilkan data user dengan id yang diberikan.
- PUT `/api/v1/users/:id`, masukkan nomor id pada endpoint, masukkan firstName dan lastName pada body request. Endpoint ini akan mengupdate firstName dan lastName dari user dengan id yang dimasukkan.
- DELETE `/api/v1/users/:id`, masukkan id pada endpoint, data user dengan id yang diberikan akan dihapus dari tabel.
