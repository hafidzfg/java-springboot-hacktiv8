# Non Structured Database/NoSQL (MongoDB)

Pada sesi ini, dipelajari mengenai sebuah database non structured, yakni MongoDB.

MongoDB adalah sebuah NoSQL database yang menyimpan data dalam bentuk BSON (Binary JSON), sedangkan JSON sendiri adalah Javascript Object Notation Language. BSON memiliki keunggulan antara lain dapat menyimpan tipe data yang lebih banyak dibanding native JSON, seperti tipe data binary dan date. Data pada MongoDB disimpan dalam bentuk key dan value. Berikut contoh data sederhana:

```
{
    "key": "value",
}
```

1. Lakukan installasi MongoDB <br>
   [MongoDB](https://www.mongodb.com/try/download/community?tck=docs_server)<br>

2. Operasi dasar <br>
   Untuk mengecek versi yang terinstal jalankan:

```
mongo --version
```

Untuk memulai MongoDB:

```
mongo start
```

Untuk membuat database:

```
use NAMA_DATABASE
```

## Practice MongoDB Basic

**a. Relasi One-to-One** <br>
Pada demonstrasi di bawah, kita membuat collection dengan relasi one-to-one, artinya satu data di tabel A berelasi dengan satu data di tabel B.

1. Membuat collection <br>
   Data dalam database disimpan di dalam collection, collection ini serupa dengan tabel dalam SQL. Untuk membuat sebuah collection, berikut contoh kita membuat collection bernama "penyakit" dan "pasien":

```
db.createCollection("penyakit");

db.createCollection("pasien");
```

2. Memasukkan data ke collection <br>
   Tiap data dalam collection memiliki field (column) dan document (row). Berikut demonstrasi memasukkan data ke dalam collection "penyakit" dan "pasien":

```
db.pasien.insertOne({nama : "Foxy", umur:20, penyakit: "sakit_0001"});

db.penyakit.insertOne({_id : "sakit_0001", penyakit:"flu"});
```

3. Membuat variabel <br>
   Kita dapat membuat variabel dari query MongoDB yang kita buat. Sehingga, selanjutnya kita cukup memanggil variabel tersebut untuk menjalankan query yang kita simpan. Berikut contohnya:

```
var penyakit_id = db.pasien.findOne().penyakit;
```

Jika kita memanggil penyakit_id, akan didapatkan data "sakit_0001". Sehingga kita dapat memakainya seperti ini:

```
db.penyakit.findOne({_id : penyakit_id});
```

hasilnya akan muncul:

```
{"_id" : "sakit_0001", "penyakit" : "flu" };
```

**b. Relasi one-to-many** <br>
Sekarang kita coba membuat collection dengan relasi one-to-many. Artinya sebuah data di tabel A dapat digunakan oleh beberapa data di tabel B.

1. Membuat collection

```
db.createCollection("pelanggan");

db.createCollection("transaksi");
```

2. Membuat field

```
db.pelanggan.insertMany([{_id : "PL0001", nama_pelanggan : "Brudi"}, {{_id : "PL0002", nama_pelanggan : "Bobo"}}]);

db.transaksi.insertMany([{_id : "TR0001", tanggal_transaksi : new Date(), total_harga : 100000 , id_pelanggan : "PL0001"}, {{_id : "TR0002", tanggal_transaksi : new Date(), total_harga : 500000 , id_pelanggan : "PL0002"}, {{_id : "TR0003", tanggal_transaksi : new Date(), total_harga : 570000 , id_pelanggan : "PL0001"}, {{_id : "TR0004", tanggal_transaksi : new Date(), total_harga : 100000 , id_pelanggan : "PL0001"}]);
```

3. Memanggil data

```
db.transaksi.find().pretty();
```

Jika kita jalankan perintah di atas, akan dikembalikan isi dari collection transaksi, collection ini menampung banyak transaksi yang dilakukan oleh pelanggan yang berbeda ataupun sama. Artinya terlihat seorang pelanggan dari collection pelanggan dapat memiliki banyak data (transaksi) di collection transaksi.

**c. Relasi many-to-many** <br>
Sekarang kita buat collection dengan relasi many-to-many. Artinya beberapa data dalam tabel A dapat berelasi dengan beberapa data pula dalam tabel B.

1. Buat collection

```
db.createCollection("detail_transaksi");
```

2. Masukkan field

```
db.detail_transaksi.insertMany([{no_trans : "TR0001",barang : "Gelas",jumlah : 3},{no_trans : "TR0002", barang : "Topi", jumlah : 1},{no_trans : "TR0003",barang : "Ember",jumlah : 2},{no_trans : "Gelang", barang : "Gelas", jumlah : 5}]);
```

## Lookup

Lookup adalah sebuah metode yang digunakan untuk menampilkan data seperti find tetapi di lookup ini kita dapat menampilkan beberapa tabel untuk di tampilkan.

Lookup mirip seperti JOIN pada SQL. <br>
Contohnya, mari kita lakukan lookup untuk collection yang telah kita buat sebelumnya.

```
db.pelanggan.aggregate( [ { $lookup : { from : "transaksi", localField : "_id", foreignField : "id_pelanggan", as : "join" } } ] )
```

## Validator

Validasi adalah sebuah metode untuk mengecek suatu data yang dimasukkan. Semisal kita mengecek nama user yang harus dimasukkan bertipe string.

Berikut kita akan buat validator untuk sebuah collection.

```
db.createCollection("barang", {
    validator : {
        $jsonSchema : {
            bsonType: "object",
            required : ["namabarang", "hargabarang", "description"]
        },
        namaBarang : {
            bsonType: "string",
            Description: "Nama barang harus berupa karakter dan tidak boleh kosong!"
        },
        hargaBarang : {
            bsonType : "number",
            Description : "Harga Barang harus berupa number dan tidak boleh kosong!"
        },
        jenisBarang : {
            bsonType : "objectId",
            Description : "Jenis Barang harus berupa objectID dan tidak boleh kosong!"
        },
        description : {
            bsonType : "array",
            Description : "Deskripsi harus berupa karakter dan tidak boleh kosong!",
            Items : {
                Merk : {
                    bsonType : "string",
                    description : "Ukuran harus berupa karakter dan tidak boleh kosong!"
                },
                ukuran : {
                    bsonType : "string",
                    description : "Ukuran harus berupa karakter dan tidak boleh kosong!"
                },
                stok : {
                    bsonType :"number",
                    description : "Stok harus berupa angka dan tidak boleh kosong!"
                }
            }
        }
    }
});
```
