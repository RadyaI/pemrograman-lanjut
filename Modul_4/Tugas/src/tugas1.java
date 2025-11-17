import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class tugas1 {

    private static final ArrayList<String> judul = new ArrayList<>();
    private static final ArrayList<Integer> tahun = new ArrayList<>();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        judul.add("Upin ipin");
        judul.add("Spongebob");
        judul.add("Doraemon");

        tahun.add(2000);
        tahun.add(2005);
        tahun.add(2010);

        boolean jalan = true;

        while (jalan) {
            int p = menu();
            jalan = proses(p);
        }
    }

    private static int menu() {
        System.out.println("\n=== Menu Manajemen Film ===");
        System.out.println("1. Tambah Film Baru");
        System.out.println("2. Urutkan Berdasarkan Nama Film (A-Z)");
        System.out.println("3. Urutkan Berdasarkan Tahun (Ascending)");
        System.out.println("4. Keluar Program");
        System.out.print("Masukkan pilihan (1-4): ");

        return in.nextInt();
    }

    private static boolean proses(int p) {
        switch (p) {
            case 1 -> tambahFilm();
            case 2 -> urutNama();
            case 3 -> urutTahun();
            case 4 -> {
                System.out.println("Keluar dari program.");
                return false;
            }
            default -> System.out.println("Pilihan tidak valid.");
        }
        return true;
    }

    private static void tambahFilm() {
        in.nextLine();
        System.out.print("Masukkan judul film: ");
        judul.add(in.nextLine());
        System.out.print("Masukkan tahun rilis: ");
        tahun.add(Integer.parseInt(in.nextLine()));
        System.out.println("Film berhasil ditambahkan.");
    }

    private static void urutNama() {
        ArrayList<Integer> idx = new ArrayList<>();
        for (int i = 0; i < judul.size(); i++){
            idx.add(i);
        }

        idx.sort(Comparator.comparing(i -> judul.get(i).toLowerCase()));

        System.out.println("\n=== Daftar Film (Urut Nama A-Z) ===");
        for (int i : idx) {
            System.out.println("Judul: " + judul.get(i) + ", Tahun: " + tahun.get(i));
        }
    }

    private static void urutTahun() {
        ArrayList<Integer> idx = new ArrayList<>();
        for (int i = 0; i < tahun.size(); i++){
            idx.add(i);
        }

        idx.sort(Comparator.comparingInt(i -> tahun.get(i)));

        System.out.println("\n=== Daftar Film (Urut Tahun Ascending) ===");
        for (int i : idx) {
            System.out.println("Judul: " + judul.get(i) + ", Tahun: " + tahun.get(i));
        }
    }
}
