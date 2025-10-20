# 🧠 Program Input, Output, dan Method Sederhana (Java)

Program ini dibuat untuk mendemonstrasikan penggunaan **input/output**, **struktur `if-else`**, serta **pemanggilan method** di dalam satu kelas (`Main`) pada bahasa pemrograman Java.

## 📌 Fitur

* Menerima input **nama** dan **umur** dari user.
* Menampilkan sapaan dengan nama.
* Mengecek apakah user **dewasa** atau **remaja** menggunakan kondisi `if-else`.
* Menggunakan beberapa **method statis** untuk modularisasi kode.

## 🛠️ Teknologi

* Bahasa: **Java**
* Kompiler: `javac`
* Runtime: `java`

## 📂 Struktur File

```
.
├── Main.java
└── README.md
```

## 📝 Kode Program

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input
        System.out.print("Masukkan nama kamu: ");
        String nama = input.nextLine();

        System.out.print("Masukkan umur kamu: ");
        int umur = input.nextInt();

        // Proses & Output
        sapaUser(nama);
        cekUmur(umur);

        input.close();
    }

    // Method untuk menyapa user
    public static void sapaUser(String nama) {
        System.out.println("\nHalo, " + nama + "!");
    }

    // Method untuk mengecek umur
    public static void cekUmur(int umur) {
        if (umur >= 18) {
            System.out.println("Kamu sudah dewasa.");
        } else {
            System.out.println("Kamu masih remaja.");
        }
    }
}
```

## 🚀 Cara Menjalankan Program

1. **Simpan** file dengan nama `Main.java`
2. **Buka terminal** dan masuk ke direktori file tersebut
3. **Compile** program:

   ```bash
   javac Main.java
   ```
4. **Jalankan** program:

   ```bash
   java Main
   ```

## 💻 Contoh Output

```
Masukkan nama kamu: Radya
Masukkan umur kamu: 19

Halo, Radya!
Kamu sudah dewasa.
```

## 📚 Penjelasan Method

| Method     | Parameter     | Deskripsi                                                 |
| ---------- | ------------- | --------------------------------------------------------- |
| `sapaUser` | `String nama` | Menampilkan sapaan berdasarkan nama yang diinputkan user. |
| `cekUmur`  | `int umur`    | Mengecek umur dan menampilkan status remaja atau dewasa.  |
