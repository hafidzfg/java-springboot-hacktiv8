Hibernate
Hibernate adalah sebuah ORM (object relationship mapping) yang digunakan sebagai penghubung antara scripting language (java) dengan query language (SQL). Dalam pengembangan sebuah aplikasi, penggunaan query SQL di dalam java semakin banyak akan semakin menambah kompleksitas, oleh karena itu digunakan ORM sehingga kita dapat menjalankan query (memanipulasi database atau mendifinisikan database) menggunakan method dalam java.

Impedance Mismatch
Semakin banyaknya query SQL didalam source code Java akan merepotkan developer karena penggunaan SQL sangat berbeda dengan Java, contoh:

Pada saat kita melakukan parsing variabel mulai dari database, set up koneksi dan Operasi CRUD tentu halini ber-impact pada Performance & Maintainability app Java yang kita buat.

Hal ini disebut dengan Impedance Mismatch

Pada sesi ini, dibuat sebuah aplikasi java yang membuat sebuah tabel bernama "address_book".

Pastikan MySQL sudah terinstal
Anda dapat menginstal MySQL untuk OS anda, atau anda dapat menggunakan XAMPP.

Buat database
Buat database bernama "test" di dalam MySQL

Jalankan App.java
Jalankan App.java, ketika dijalankan, akan dibuat tabel bernama address_book. Aplikasi yang kita buat juga sekaligus akan mengisi tabel dengan sebuah data.
