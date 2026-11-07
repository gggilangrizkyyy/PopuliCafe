# ☕ Populi Cafe *Vox populi, vox caffeine.* ☕

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

Halaman yang ditampilkan:
1. Splash Screen 
<img width="601" height="1280" alt="Splash" src="https://github.com/user-attachments/assets/2d73fc71-4bb9-4119-b83c-73bb8794f697" />

2. Sign Up
<img width="597" height="1280" alt="Signup" src="https://github.com/user-attachments/assets/5b07688c-cf43-4438-a6ec-0c1e90d61b63" />

3. Login
<img width="598" height="1280" alt="Login" src="https://github.com/user-attachments/assets/86f7dba5-f464-443c-b431-c7d881c49def" />

5. Register
<img width="596" height="1280" alt="Register" src="https://github.com/user-attachments/assets/5291e3c3-e153-433e-8460-267f010bbcc2" />

7. Home
<img width="576" height="1280" alt="Home" src="https://github.com/user-attachments/assets/2c26f388-5a10-4249-b8e3-90941026595f" />
<img width="600" height="1280" alt="Home2" src="https://github.com/user-attachments/assets/53ee3d24-bc37-4917-9a3b-60ac0d23b69c" />

8. Order
<img width="598" height="1280" alt="Order" src="https://github.com/user-attachments/assets/a8e13f8d-bc37-4ea8-a016-e77698c7937a" />

9. Alamat Pengiriman
<img width="598" height="1280" alt="Delivery" src="https://github.com/user-attachments/assets/ef79f30f-ff90-41c7-8b56-2a139a825cc4" />

10. Konfirmasi Pesanan
<img width="601" height="1280" alt="Confirmation" src="https://github.com/user-attachments/assets/18d4e5e4-b1fb-49bd-8df2-a9ebaa0cd14f" />

11. Profile
<img width="600" height="1280" alt="Profile" src="https://github.com/user-attachments/assets/2238e200-2414-486b-b7ec-ee2f9eefb3bb" />


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
