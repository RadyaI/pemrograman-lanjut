package org.example;

public class Mahasiswa {
    private String nama;
    private int semester;
    private String mataKuliah;

    public Mahasiswa(String nama, int semester, String mataKuliah) {
        this.nama = nama;
        this.semester = semester;
        this.mataKuliah = mataKuliah;
    }

    public String getNama() {
        return nama;
    }

    public int getSemester() {
        return semester;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }
}
