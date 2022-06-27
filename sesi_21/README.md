# Deployment to Heroku & Push Notification with Firebase

Pada sesi ini dilakukan latihan deployment ke Heroku dan penggunaan Firebase untuk push notification.

## Deployment to Heroku

Project folder `BelajarDeployment` dideploy dengan mengimport repository folder ini ke heroku. Untuk mengakses project ini yang sudah dideploy, anda dapat membuka: <br>
[heroku](https://heroku-app-hacktiv8.herokuapp.com/api/hello`) <br>
Halaman tersebut akan menampilkan hasil isi dari endpoint `api/hello` yang dibuat di dalam controller project ini.

## Push notification with Firebase

Project yang digunakan terdapat pada folder `BelajarFirebase`. Sebelumnya dilakukan setup terlebih dahulu dengan konfigurasi firebase yang terdapat di `resources/firebase-service-account.json`. Firebase disini digunakan untuk mengirimkan notifikasi melalui layanan Firebase Cloud Messaging (FCM) yang disediakan oleh Firebase.

Untuk mengakses FCM:

1. Jalankan project: `mvn spring-boot:run`
2. Hit endpoint berikut: `http://localhost:8080/send-notification?topic=gold` dengan request body json:

```
{
    "subject": "some subject",
    "content": "Some long content",
    "image": "https://upload.wikimedia.org/wikipedia/en/9/95/Test_image.jpg",
    "data": {
      "key1": "Value 1",
      "key2": "Value 2",
      "key3": "Value 3",
      "key4": "Value 4"
    }
}
```
