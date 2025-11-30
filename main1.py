import json
import os

file_name = "data_buku.json"

def load_data():
    if os.path.exists(file_name):
        with open(file_name, "r") as file:
            data = json.load(file)
    else:
        data = []
    return data

def save_data(data):
    with open(file_name, "w") as file:
        json.dump(data, file, indent=4)

def tambah_buku():
    print("\nMenambahkan Buku Baru")

    judul = input("Masukkan judul buku: ")
    pengarang = input("Masukkan pengarang buku: ")
    tahun = input("Masukkan tahun terbit buku: ")

    data = load_data()

    buku = {
        "judul": judul,
        "pengarang": pengarang,
        "tahun": tahun
    }

    data.append(buku)
    save_data(data)

    print("Buku berhasil ditambahkan!\n")

def tampilkan_buku():
    print("\n--- Daftar Buku ---")
    data = load_data()

    if len(data) == 0:
        print("Belum ada buku.\n")
    else:
        for i in range(len(data)):
            buku = data[i]
            print(str(i+1) + ". " + buku["judul"] + " - " + buku["pengarang"] + " (" + buku["tahun"] + ")")
        print("")

def update_buku():
    data = load_data()

    if len(data) == 0:
        print("Belum ada buku untuk diupdate.\n")
        return

    tampilkan_buku()

    nomor = int(input("Pilih nomor buku yang ingin diupdate: ")) - 1

    if nomor < 0 or nomor >= len(data):
        print("Nomor tidak valid.\n")
        return

    buku = data[nomor]

    print("\nKosongi input jika tidak ingin mengubah.")

    judul_baru = input("Judul baru (" + buku["judul"] + "): ")
    pengarang_baru = input("Pengarang baru (" + buku["pengarang"] + "): ")
    tahun_baru = input("Tahun baru (" + buku["tahun"] + "): ")

    if judul_baru != "":
        buku["judul"] = judul_baru
    if pengarang_baru != "":
        buku["pengarang"] = pengarang_baru
    if tahun_baru != "":
        buku["tahun"] = tahun_baru

    save_data(data)
    print("Buku berhasil diupdate!\n")

def hapus_buku():
    data = load_data()

    if len(data) == 0:
        print("Belum ada buku untuk dihapus.\n")
        return

    tampilkan_buku()

    nomor = int(input("Pilih nomor buku yang ingin dihapus: ")) - 1

    if nomor < 0 or nomor >= len(data):
        print("Nomor tidak valid.\n")
        return

    data.pop(nomor)
    save_data(data)

    print("Buku berhasil dihapus!\n")

def main():
    while True:
        print("--- Menu Perpustakaan ---")
        print("1. Menambahkan Buku")
        print("2. Menampilkan Buku")
        print("3. Mengupdate Buku")
        print("4. Menghapus Buku")
        print("5. Keluar")

        pilihan = input("Pilih menu (1/2/3/4/5): ")

        if pilihan == "1":
            tambah_buku()
        elif pilihan == "2":
            tampilkan_buku()
        elif pilihan == "3":
            update_buku()
        elif pilihan == "4":
            hapus_buku()
        elif pilihan == "5":
            print("Keluar program...")
            break
        else:
            print("Pilihan tidak valid.\n")

main()
