# ☕ Populi Cafe

**Aplikasi Pemesanan Kopi dan Camilan Berbasis Android**

Populi Cafe adalah aplikasi mobile pemesanan kopi, camilan, dan makanan yang dirancang untuk memberikan pengalaman pemesanan yang mudah, praktis, dan nyaman.

Aplikasi ini dikembangkan sebagai proyek tugas Pemrograman Mobile menggunakan Kotlin dan Jetpack Compose dengan data dummy tanpa database.

## ✨ Fitur Aplikasi

- **Splash & Welcome** — Halaman pembuka aplikasi.
- **Sign Up & Register** — Pendaftaran pengguna.
- **Login** — Autentikasi pengguna secara lokal.
- **Home** — Menampilkan 12 pilihan menu makanan dan minuman.
- **Kategori Menu** — Filter Minuman, Camilan, dan Makanan.
- **Keranjang** — Menambah, mengurangi, dan menghapus pesanan.
- **Checkout** — Menghitung subtotal secara otomatis.
- **Alamat Pengiriman** — Form nama penerima, alamat, dan patokan lokasi.
- **Konfirmasi Pesanan** — Menampilkan status pesanan berhasil.
- **Profile** — Melihat dan mengubah nama pengguna.
- **Bottom Navigation** — Navigasi Home, Order, dan Profile.

## 🛠️ Teknologi yang Digunakan

| Teknologi | Kegunaan |
|---|---|
| Kotlin | Bahasa pemrograman |
| Android Studio | IDE pengembangan |
| Jetpack Compose | Membangun antarmuka |
| Material 3 | Komponen UI |
| Navigation Compose | Navigasi antarhalaman |
| ViewModel | Pengelolaan state aplikasi |

## 🎨 Konsep Desain

Populi Cafe menggunakan konsep desain hangat dan sederhana dengan inspirasi warung kopi sebagai ruang berkumpul masyarakat.

Palet warna:
- Cream: `#F5EDE0`
- Espresso: `#2B1D16`
- Terracotta: `#B5522E`
- Gold: `#C9A24B`
- Sage: `#8DAA7F`

## 📱 Screenshot Aplikasi

Screenshot aplikasi dapat dilihat pada folder `Screenshots/` di repository ini.

Halaman yang ditampilkan:
1. Splash Screen
2. Sign Up
3. Login
4. Register
5. Home
6. Order
7. Alamat Pengiriman
8. Konfirmasi Pesanan
9. Profile

## 📂 Struktur Project

```text
PopuliCafe/
│
├── app/
│   ├── src/
│   │   ├── androidTest/
│   │   │   └── java/
│   │   │       └── lat/pam/populicafe/
│   │   │           └── ExampleInstrumentedTest.kt
│   │   │
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── lat/
│   │   │   │       └── pam/
│   │   │   │           └── populicafe/
│   │   │   │               │
│   │   │   │               ├── data/
│   │   │   │               │   └── model/
│   │   │   │               │       └── MenuItem.kt
│   │   │   │               │
│   │   │   │               ├── navigation/
│   │   │   │               │   └── AppNavigation.kt
│   │   │   │               │
│   │   │   │               ├── ui/
│   │   │   │               │   ├── screens/
│   │   │   │               │   │   ├── home/
│   │   │   │               │   │   │   └── HomeScreen.kt
│   │   │   │               │   │   │
│   │   │   │               │   │   ├── order/
│   │   │   │               │   │   │   ├── ConfirmationScreen.kt
│   │   │   │               │   │   │   ├── DeliveryScreen.kt
│   │   │   │               │   │   │   └── OrderScreen.kt
│   │   │   │               │   │   │
│   │   │   │               │   │   └── profile/
│   │   │   │               │   │       └── ProfileScreen.kt
│   │   │   │               │   │
│   │   │   │               │   └── theme/
│   │   │   │               │       ├── Color.kt
│   │   │   │               │       ├── Theme.kt
│   │   │   │               │       └── Type.kt
│   │   │   │               │
│   │   │   │               ├── viewmodel/
│   │   │   │               │   ├── CartViewModel.kt
│   │   │   │               │   └── ProfileViewModel.kt
│   │   │   │               │
│   │   │   │               └── MainActivity.kt
│   │   │   │
│   │   │   ├── keepRules/
│   │   │   │   └── rules.keep
│   │   │   │
│   │   │   ├── res/
│   │   │   └── AndroidManifest.xml
│   │   │
│   │   └── test/
│   │       └── java/
│   │           └── lat/pam/populicafe/
│   │               └── ExampleUnitTest.kt
│   │
│   └── build.gradle.kts
│
├── gradle/
│   ├── wrapper/
│   │   ├── gradle-wrapper.jar
│   │   └── gradle-wrapper.properties
│   ├── gradle-daemon-jvm.properties
│   └── libs.versions.toml
│
├── Screenshots/
│   ├── Confirmation.jpeg
│   ├── Delivery.jpeg
│   ├── Home.jpeg
│   ├── Home2.jpeg
│   ├── Login.jpeg
│   ├── Order.jpeg
│   ├── Profile.jpeg
│   ├── Register.jpeg
│   ├── Signup.jpeg
│   └── Splash.jpeg
│
├── README.md
├── .gitignore
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts
```

## 🚀 Cara Menjalankan Aplikasi

1. Clone repository:

   ```bash
   git clone https://github.com/USERNAME/PopuliCafe.git
   ```

2. Buka Android Studio.
3. Pilih **Open** dan pilih folder `PopuliCafe`.
4. Tunggu proses Gradle Sync selesai.
5. Hubungkan perangkat Android atau jalankan emulator.
6. Klik tombol **Run ▶**.
7. Aplikasi Populi Cafe siap digunakan.

## 📝 Catatan Pengembangan

- Aplikasi menggunakan data dummy atau statis.
- Tidak menggunakan database.
- Data keranjang dan profil dikelola menggunakan state dan ViewModel.
- Data dapat kembali ke kondisi awal ketika aplikasi dijalankan ulang.
- Login dan Register merupakan simulasi lokal, bukan autentikasi server.
- Pembayaran online belum diimplementasikan.

## 👨‍💻 Developer

**Nama:** Gilang Rizky Ramadhan  
**NIM:** 1247050049
**Program Studi:** Teknik Informatika
**Mata Kuliah:** Pengembangan Aplikasi Mobile

---

*Populi Cafe — Vox populi, vox caffeine.* ☕
