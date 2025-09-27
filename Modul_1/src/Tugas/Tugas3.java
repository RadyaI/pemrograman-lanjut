package Tugas;

import java.util.Scanner;

public class Tugas3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan nilai ujian akhir: ");
        int nilai = scanner.nextInt();

        if (nilai >= 60) {
            System.out.println("Nama: " + nama + " | Status: Lulus");
        } else {
            System.out.println("Nama: " + nama + " | Status: Tidak Lulus");
        }

        scanner.close();
    }
}

//P(Precondition) C(Command) Q(Postcondition)
//{nilai >= 0 ∧ nilai <= 100} C {status = "Lulus" jika nilai >= 60, "Tidak Lulus" jika nilai < 60}

//Informal
//1. Program meminta input nama mahasiswa dan nilai ujian akhir (0–100).
//2. Program memeriksa nilai ujian akhir. Jika nilai ≥ 60, maka status = “Lulus”, jika < 60 maka status = “Tidak Lulus”.
//3. Program menampilkan nama mahasiswa beserta status kelulusannya.