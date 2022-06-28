# Code Coverage with Sonarqube

Project ini berisi percobaan evaluasi code coverage dengan Sonarqube. Sonarqube adalah salah satu utility yang dapat kita gunakan untuk menilai code coverage dari project yang kita buat.

## Requirement

- JDK 11+
- Sonarqube

## How to test

1. Mulai Sonarqube `**\sonarqube\bin\windows-x86-64\StartSonar.bat`
2. Buka Sonarqube `http://localhost:9191/`
3. Masuk ke Project > Create Project > Manually > Masukkan nama project kamu
4. Pilih Locally > Create Project Token > Continue > Maven
5. Jalankan perintah yang diberikan di folder project ini (di dalam `SpringProductJacoco`)

```
# Contoh
# Sesuaikan dengan yang digenerate dari Sonarqube kamu
mvn clean verify sonar:sonar -Dsonar.projectKey=TestTerakhir -Dsonar.host.url=http://localhost:9191 -Dsonar.login=sqp_690xxxxxxxx
```

6. Cek hasil evaluasi project kamu di `http://localhost:9191/projects`
