# Restful API dan Restful Web

Pada sesi ini, dilakukan latihan membuat Restful Web Services dan Restful API.

Terdapat dua project:

1. AssignmentRestAPI
2. BelajarRestfulWeb

**Untuk detailnya, silakan buka folder masing-masing project.**

## Web service vs Web API

Perbedaan antara web API dan web service antara lain adalah:

1. Web service memfasilitasi untuk melakukan interaksi antara dua perangkat atau aplikasi melaluijaringan. Sedangkan API bertindak sebagai penghubung antara dua aplikasi berbeda sehingga bisaberkomunikasi satu sama lain baik dengan ataupun tanpa jaringan.
2. Semua web service menggunakan API tapi tidak semua API digunakan sebagai web service
3. Web service selalu membutuhkan jaringan untuk pengoperasiannya sedangkan API tidak selalumemerlukan jaringan untuk operasinya.
4. Web service hanya menggunakan 3 style yaitu SOAP, REST, atau XML-RPC untuk berkomunikasi sedangkan API dapat menggunakan style apapun.

## REST

REST (Representational State) adalah cara kita untuk menggunakan resource (fungsi/method) yang ada di sebuah server dengan mengakses url yang telah disediakan.Cara mengaksesnya tentu dengan menggunakan HTTP (Hyper Text Transfer Protocol) dengan method(httpverb) yang umum digunakan yaitu:

- GET: untuk membaca resource (data).
- POST: untuk membuat resource baru (data baru).
- DELETE: tentu untuk menghapus resource (data).
- PUT: untuk merubah resource (data).

### Komponen Rest API

- HTTP method seperti GET, POST, PUT, DELETE dllsesuai dengan tugasnya masing-masing.
- URI (Uniform Resource Identifier) untuk mengetahui lokasi data di server.
- HTTP Version, seperti HTTP v1.1.
- Request Header, berisi metadata seperti Authorization,tipe client dan lain
- Request Body, data yang diberikan client ke server seperti URI params.

### Prinsip Restful API

- Uniform Interface: Antarmuka komponen harus sama. Ini berarti menggunakan sekitar URI (Uniform Resource Identifier) untuk mengidentifikasi sumber daya—dengan kata lain, path yang dapat dimasukkan ke bilah lokasi browser.
- Client-Server: Ada pemisahan kekhawatiran antara server, yang menyimpan dan memanipulasi data, dan klien,yang meminta dan menampilkan respon.
- Stateless Interactions: Semua informasi tentang setiap permintaan terkandung dalam setiap permintaanindividudan tidak tergantung pada status session.
- Cacheable: Klien dan server dapat menyimpan sumber daya.
- Layered System: Klien dapat dihubungkan ke server akhir, atau lapisan menengah seperti load-balancer.
- Code on Demand (Opsional): Seorang klien dapat mengunduh kode, yang mengurangi visibilitas dari luar.

### Kode Response

1. Informational responses (100–199)
2. Successful responses (200–299)
3. Redirection messages (300–399)
4. Client error responses (400–499)
5. Server error responses (500–599)

## Pembuatan Restful Web Services

1. Buat project Spring dengan dependency: Spring Web, Spring Web Tools
2. Setting application.properties
3. Buat Controller

## Pembuatan Restful API dengan Springboot & MySQL

1. Tambahkan dependency: Driver MySQL, Spring Data JPA, Spring Web, Spring Web Tools
2. Buat database dan configure application.properties
3. Buat Entity/Model Class
4. Buat Repository Interface
5. Buat Service Class
6. Buat REST Controller Class
