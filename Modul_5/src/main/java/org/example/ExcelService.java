package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;

public class ExcelService {

    private static final String FILE_PATH = "src/main/resources/data_mahasiswa.xlsx";

    public Workbook loadOrCreateWorkbook() {
        try {
            Path path = Paths.get(FILE_PATH);

            if (Files.exists(path)) {
                try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
                    return new XSSFWorkbook(fis);
                }
            } else {
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Mahasiswa");

                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Nama");
                header.createCell(1).setCellValue("Semester");
                header.createCell(2).setCellValue("Mata Kuliah");

                saveWorkbook(wb);
                return wb;
            }
        } catch (Exception e) {
            throw new RuntimeException("Gagal membuat/membaca file workbook", e);
        }
    }

    public void saveWorkbook(Workbook workbook) {
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            workbook.write(fos);
        } catch (Exception e) {
            throw new RuntimeException("Gagal menyimpan workbook", e);
        }
    }

    public Set<String> loadExistingNames(Sheet sheet) {
        Set<String> set = new HashSet<>();
        int rows = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < rows; i++) {
            Row r = sheet.getRow(i);
            if (r != null) {
                Cell c = r.getCell(0);
                if (c != null) {
                    set.add(c.getStringCellValue().toLowerCase());
                }
            }
        }
        return set;
    }

    public void appendMahasiswa(Sheet sheet, Mahasiswa mhs) {
        int newRow = sheet.getPhysicalNumberOfRows();
        Row row = sheet.createRow(newRow);

        row.createCell(0).setCellValue(mhs.getNama());
        row.createCell(1).setCellValue(mhs.getSemester());
        row.createCell(2).setCellValue(mhs.getMataKuliah());
    }
}
