# Final Project: Bus Ticket Reservation

Pada final project ini dibuat APIs untuk sebuah aplikasi pemesanan tiket bus.

## Requirement

1. Java 1.8
2. MySQL/XAMPP
   Buat sebuah database dengan nama `h8_bus`
3. Maven
4. IDE (Project ini dibuat dengan Eclipse IDE)

## How to run

1. Navigasi ke dalam folder `FinalProject`
2. Jalankan database kamu
3. Jalankan: `mvn spring-boot:run`
   Pada tahap ini program akan membuat tabel di dalam database dan mengeksekusi beberapa migrasi dengan FlyWay
4. Hit API otentikasi sebelum mengakses API yang lain:

- **Dengan Postman**: Hit API POST `http://localhost:8080/api/auth`
  Masukkan pada request body

```
{
    "password" : "admin123",
    "username" : "admin"
}
```

Copy token yang anda dapatkan di response body, lalu masukkan `Authorization` pada request header untuk api yang akan anda hit, pada keynya masukkan `Bearer XYZXZXZX`, dimana XYZXZXZX adalah token yang kamu dapat dari api Auth.

- **Dengan Swagger-UI**: masuk ke swagger-ui: `http://localhost:8080/swagger-ui.html`
  Masuk ke auth-controller > `api/auth`
  Masukkan pada request body

```
{
    "password" : "admin123",
    "username" : "admin"
}
```

Anda akan mendapatkan sebuah token seperti "Biuh013pajsxxxxxxxxxx" pada response body. Klik `Authorization` pada bagian kanan atas swagger-ui, lalu masukkan `Bearer {token}`, dimana {token} merupakan token yang kamu dapat dari hasil hit endpoint Auth.

5. Hit endpoint yang kamu butuhkan.

- Akses via swagger-ui : `http://localhost:8080/swagger-ui.html`
- Akses via Postman: anda dapat download file [Postman Collection](./documentation/FinalProject_Hafidz%20Firmansyah%20Ghufara_Postman.postman_collection.json), lalu import ke Postman kamu.

## Endpoints

### Endpoint tanpa otentikasi

Terdapat beberapa endpoint yang dapat diakses tanpa otentikasi sama sekali

1. Signup POST `/api/v1/user/signup` untuk membuat user baru
2. Auth GET `/api/v1/auth` untuk generate token untuk otentikasi

### Endpoint dengan otentikasi **'USER' atau 'ADMIN'**

Endpoint berikut dapat diakses oleh user dengan role 'USER' ataupun 'ADMIN'

- Reservation

1. POST `/api/v1/reservation/booktickets` <br>
   Untuk booking ticket/perjalanan
2. GET `/api/v1/reservation/tripbystops` <br>
   Untuk mencari trip yang berangkat dari stop awal (SourceStopId) dan berhenti di stop tujuan (DestStopId) yang diinput ke request body
3. GET `/api/v1/reservation/tripschedules` <br>
   Untuk menampilkan semua schedule trip yang tersedia di database

- TripSchedule

1. GET `/api/v1/trip_schedule/` menampilkan semua schedule trip yang tersedia
2. GET `/api/v1/trip_schedule/{id}` menampilkan schedule trip dengan id yang diberikan pada endpoint

- User

1. GET `/api/v1/user/{id}` menampilkan detail user yang memiliki id yang diberikan pada endpoint
2. PUT `/api/v1/user/{id}` mengupdate data user yang memiliki id yang diberikan ke endpoint.
   request body:

```
{
    "firstName": "nama depan",
    "lastName": "nama belakang",
    "mobileNumber": "nomer telepon"
}
```

3. PUT `/api/v1/user/password/{id}` mengubah password dari user yang memiliki id yang diberikan.

```
{
    "password": "password baru kamu"
}
```

### Endpoint yang dapat diakses oleh user dengan role **'ADMIN'**

Admin dapat mengakses semua endpoint yang tersedia, adapun berikut detail akun admin yang terdaftar:

```
{
    "username": "admin",
    "password": "admin123"
}
```
