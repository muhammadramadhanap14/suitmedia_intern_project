# Suitmedia Internship Project

## Deskripsi
Proyek ini adalah aplikasi Android yang dibuat sebagai bagian dari magang di Suitmedia. Aplikasi ini memiliki beberapa layar dengan fungsionalitas tertentu, seperti memeriksa apakah sebuah kalimat adalah palindrom dan melanjutkan ke layar berikutnya. Aplikasi ini dibangun menggunakan Kotlin dan Android SDK.

## Fitur
- **Halaman Pertama (FirstScreenActivity)**: Pengguna dapat memasukkan nama mereka dan sebuah kalimat untuk diperiksa apakah itu palindrom.
  - Jika kalimat merupakan palindrom, maka aplikasi akan menampilkan dialog "isPalindrome".
  - Jika kalimat bukan palindrom, aplikasi akan menampilkan dialog "not palindrome".
  - Jika nama pengguna tidak dimasukkan, akan muncul dialog untuk meminta nama terlebih dahulu.
- **Halaman Kedua (SecondScreenActivity)**: Setelah nama dimasukkan, pengguna dapat melanjutkan ke halaman kedua.
- **Halaman Ketiga (ThirdScreenActivity)**: 
  - Halaman ini menampilkan informasi lebih lanjut atau fitur tambahan yang dapat diakses setelah pengguna melanjutkan dari **SecondScreenActivity**.
  - Fungsi atau UI pada **ThirdScreenActivity** dapat disesuaikan lebih lanjut sesuai kebutuhan aplikasi, seperti menampilkan data yang dikirim dari **SecondScreenActivity** atau menyediakan fitur baru yang lebih interaktif.
  - Fitur ini akan dikembangkan lebih lanjut untuk menambah kegunaan aplikasi.

## Teknologi yang Digunakan
- Kotlin
- Android SDK (minSdkVersion 21, targetSdkVersion 34)
- XML untuk tampilan UI
- AlertDialog untuk menampilkan pesan

## Persyaratan
- Android Studio (atau IDE serupa) yang mendukung pengembangan Android
- Android SDK 21 atau lebih tinggi

## Struktur Proyek
```
.
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── suitmedia_internship_project
│   │   │   │               ├── FirstScreenActivity.kt
│   │   │   │               ├── SecondScreenActivity.kt
│   │   │   │               └── ThirdScreenActivity.kt
│   │   │   ├── res
│   │   │   │   ├── layout
│   │   │   │   │   ├── activity_first_screen.xml
│   │   │   │   │   ├── activity_second_screen.xml
│   │   │   │   │   └── activity_third_screen.xml
│   │   │   │   ├── mipmap
│   │   │   │   │   ├── ic_launcher.png
│   │   │   │   │   └── ic_launcher_round.png
│   │   │   │   └── values
│   │   │   │       ├── strings.xml
│   │   │   │       ├── themes.xml
│   │   │   │       └── styles.xml
├── build.gradle
└── settings.gradle
```

### Penjelasan:
- **Deskripsi**: Menjelaskan tujuan proyek dan fitur utama.
- **Teknologi yang Digunakan**: Memberikan informasi tentang teknologi dan alat yang digunakan dalam aplikasi.
- **Persyaratan**: Menyebutkan persyaratan untuk menjalankan proyek ini.
- **Struktur Proyek**: Menyediakan gambaran struktur direktori proyek.
