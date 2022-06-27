## Authentication with JWT

JSON Web Token (JWT) adalah metode otentikasi yang dapat kita gunakan untuk melakukan generasi sebuah token untuk keperluan otentikasi, misalnya untuk sistem login. <br>
Sebelum menjalankan project ini, pastikan anda telah membuat sebuah database MySQL dengan nama "db_jwt".

1. Masuk ke folder project `cd BelajarJWT`
2. Jalankan project: `mvnw spring-boot:run`
3. Akses POST `http://localhost:8081/user` untuk melakukan registrasi user <br>
   Masukkan ke dalam request body:

```
{
    "username" : "nama username kamu",
    "password" : "password kamu",
    "fullname" : "nama kamu"
}
```

4. Akses POST `http://localhost:8081/authenticate` <br>
   Masukkan identitas "username" dan "password" kamu di dalam request body <br>
   Jika detil kredensial kamu benar, maka akan diberikan response berupa token JWT. Token JWT ini berisi seperti `Bearer 9120jd0asjxxxxxxxxx`

5. Akses POST `http://localhost:8081/authenticate` <br>

   - Masukkan identitas "username" dan "password" kamu di dalam request body <br>
   - Masukkan ke dalam request header dengan key `Authentication` dengan value token jwt yang kamu dapat sebelumnya yakni `Bearer xxxxxxx` <br>
     Jika benar, kamu akan sukses terotentikasi sebagai user/sukses login.

6. Akses POST `http://localhost:8081/blog` <br>
   - Masukkan ke dalam request body:

```
{
    "title": "judul artikel blog kamu",
    "content": "isi konten kamu",
    "author": "nama kamu/author"
}
```

- Masukkan ke dalam request header dengan key `Authentication` dengan value token jwt yang kamu dapat sebelumnya yakni `Bearer xxxxxxx` <br>

Jika sukses, akan dibuat sebuah artikel blog sesuai dengan request body yang kamu masukkan.

7. Akses GET `http://localhost:8081/blog` <br>

- Masukkan ke dalam request header dengan key `Authentication` dengan value token jwt yang kamu dapat sebelumnya yakni `Bearer xxxxxxx` <br>
  Akan ditampilkan semua artikel yang telah kamu buat

8. Akses GET `http://localhost:8081/blog/{id}` <br>

- Masukkan ke dalam request header dengan key `Authentication` dengan value token jwt yang kamu dapat sebelumnya yakni `Bearer xxxxxxx` <br>
  Masukkan id ke endpoint, akan ditampilkan sebuah artikal yang memiliki id yang kamu berikan/

9. AKSES PUT `http://localhost:8081/blog/{id}` <br>

- Masukkan ke dalam request header dengan key `Authentication` dengan value token jwt yang kamu dapat sebelumnya yakni `Bearer xxxxxxx` <br>
  - Masukkan id ke endpoint, serta data "title", "content", dan "author" ke request body. Endpoint akan mengupdate data artikel yang memiliki id yang kamu berikan, dengan data yang kamu masukkan.

10. AKSES DELETE `http://localhost:8081/blog/{id}` <br>

- Masukkan ke dalam request header dengan key `Authentication` dengan value token jwt yang kamu dapat sebelumnya yakni `Bearer xxxxxxx` <br>
- Akan dihapus artikel blog yang memiliki id yang kamu berikan.
