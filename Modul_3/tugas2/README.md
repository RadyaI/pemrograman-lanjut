# Split Bill App

## Deskripsi

Aplikasi Java console untuk membagi tagihan di antara beberapa orang. Mendukung 2 mode:

1. **Sama Rata** – tagihan dibagi rata.
2. **Sesuai Porsi** – setiap orang membayar sesuai input.

Semua kelas dan method sudah didokumentasikan menggunakan JavaDoc.

## Struktur Proyek

```
src/
 ├─ MainApp.java        // Menjalankan aplikasi
 ├─ BillCalculator.java // Hitung pembagian tagihan
 ├─ Person.java         // Simpan nama & jumlah bayar
 └─ SplitOperation.java // Interface operasi pembagian
```

## Kelas & Method (Singkat)

* **MainApp:** main() → jalankan aplikasi, input user.
* **BillCalculator:** inputNamesAndAmounts(), samaRata(), sesuaiPorsi(), showResult().
* **Person:** getName(), setName(), getAmount(), setAmount().
* **SplitOperation:** samaRata(), sesuaiPorsi(), showResult().

## Cara Pakai

1. Jalankan `MainApp.java`.
2. Pilih mode (1 = rata, 2 = sesuai porsi).
3. Masukkan total tagihan & jumlah orang.
4. Input nama dan jumlah bayar.
5. Hasil pembagian muncul.

> Input jumlah bayar harus angka, program validasi otomatis.

## Contoh Output

**Sesuai Porsi:**

```
Radya membayar Rp 120000
Aini membayar Rp 111231
```

**Sama Rata:**

```
Radya membayar Rp 25000
Aini membayar Rp 25000
Budi membayar Rp 25000
Cici membayar Rp 25000
```

## JavaDoc

* Semua class & method terdokumentasi.
* Generate di IntelliJ: Tools → Generate JavaDoc → pilih folder → OK.
