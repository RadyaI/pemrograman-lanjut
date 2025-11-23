package org.example;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Scanner;
import java.util.Set;

public class InputMahasiswa {

    public static void main(String[] args) {

        ExcelService excel = new ExcelService();
        Workbook wb = excel.loadOrCreateWorkbook();
        Sheet sheet = wb.getSheetAt(0);

        Set<String> existingNames = excel.loadExistingNames(sheet);

        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan data mahasiswa. Ketik 'selesai' pada nama untuk mengakhiri.");

        while (true) {
            System.out.print("Masukkan Nama: ");
            String nama = sc.nextLine().trim();

            if (nama.equalsIgnoreCase("selesai")) {
                break;
            }

            if (existingNames.contains(nama.toLowerCase())) {
                System.out.println("Nama sudah ada, masukkan nama yang berbeda !");
                continue;
            }

            System.out.print("Masukkan Semester: ");
            int semester = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Masukkan Mata Kuliah: ");
            String mk = sc.nextLine().trim();

            Mahasiswa mhs = new Mahasiswa(nama, semester, mk);

            excel.appendMahasiswa(sheet, mhs);
            existingNames.add(nama.toLowerCase());
            excel.saveWorkbook(wb);

            System.out.println("Data berhasil disimpan ke dalam file data_mahasiswa.xlsx !");
            System.out.println();
        }

        System.out.println("Terima kasih !");
    }
}
