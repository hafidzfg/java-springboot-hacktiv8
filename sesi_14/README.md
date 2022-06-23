## Servlet & Springboot

Sesi ini mempelajari penerapan arsitektur monolitk Model-View-Controller (MVC)

a. Model: mempresentasikan data dan logika bisnis, biasanya berhubungan dengan basis data. <br>
b. View: menampilkan data atau mengatur tampilan ke pengguna <br>
c. Controller: menghubungkan antara view dengan model <br>

Aplikasi MVC umumnya memiliki:

- Servlet Controller yang menyediakan akses tunggal terhadap keseluruhan aplikasi. Controller ini bertanggung jawab menyediakan manajemen terpusat terhadap alur aplikasi dan juga service lain seperti penanganan security dan user management.
- Controller servlet umumnya menggunakan konfigurasi XML untuk menentukan alur aplikasi dan pemrosesan perintah. Hal itu juga membuat helper components terasosiasikan dengan user action dan dibuat/dipanggil untuk menangani actions yang terjadi, memanggil komponen Model sebagaimana diperlukan. Hal ini berfungsi untuk memisahkan antara controller servlet dari model.

Client (browser) mengirimkan HTTP request pada servlet container, kemudian servlet container akan menghantar request ke servlet yang dimaksud. Servlet akan menjalankan program java dan jika diperlukan servlet bisa mengakses database atau lainnya untuk menghasilkan output berupa halaman HTML.

Halaman HTML ini diserahkan ke servlet container untuk dikirim kembali sebagai response kepada client.

## Servlet

Servlet adalah program Java yang berjalan di web atau aplikasi server. Servlet berfungsi sebagai middle layer (penghubung) antar web browser atau client HTTP dengan database atau aplikasi pada server HTTP.

## Java Bean

Sebuah property java bean adalah fitur bernama yang dapat diakses oleh user dari sebuah object. Fitur ini dapat berupa data type apapun.

Ada tiga hal yang perlu diketahui tentang JavaBean, yaitu :

1. Kelas Java Bean seharunya memiliki konstruktor tanpa argument (default constructor)
2. Kelas Java Bean seharunya memiliki atribut yang didefinisikan sebagai private
3. Nilai variable di objek bean harus diakses melalui method getXxx dan SetXxx

Untuk membangun dan memanipulasi komponen Java Bean dalam halaman JSP, gunakan tiga tag berikut ini:

- jsp:useBeanTag
  Ini membangun Bean baru. Format tag selengkapnya adalah sebagai berikut:

```
<jsp:useBean id =”beanName” class=”package.Class”/>
```

- jsp:getPropertyTag
  Ini membaca nilai property bean. Membaca property pada prinsipnya memanggil method bernama getXxx. Format tag selengkapnya adalah sebagai berikut:

```
<jsp:getProperty name=”beanName” property=”propertyName”/>
```

- jsp:setPropertyTag
  Ini memodifikasi sebuah property bean (misalnya pemanggilan method bernama setXxx). Format tag selengkapnya adalah sebagai berikut:

```
<jsp:setProperty name = ‘’beanName” property = “propertyName” value=”propertyValue”/>
```

## Java Server Page (JSP)

JSP (Java Server Page) adalah suatu teknologi web berbasis bahsa pemrograman java dan berjalan di Platform Java, serta merupakan bagian teknologi J2EE (Java 2 Enterprise edition). JSP memiliki sifat-sifat sebagai berikut :

1. Portable karena dibuat dengan teknologi java
2. Manajemen memory
3. Memiliki akses ke API Java yang lengkap seperti JDBC dan Java Mail
4. Dapat menggunakan komponen yang portable dan reusable (JavaBean)
5. Memiliki kinerja tinggi terhadap banyak request atau proses sekaligus dalam waktu yang sama
6. Mudah dalam deployment dan maintenance

## Spring

Spring merupakan framework Java yang mempermudah para programmer dalam membuat sebuah aplikasi Java dengan menerapkan salah satunya adalah design-pattern: dependency-injection.

Dependency Injection atau yang biasa disingkat DI terkenal didunia pemrograman setelah banyak bermunculanframework yang menerapkan konsep ini. Salah satunya dan yang paling terkenal adalah Spring.
