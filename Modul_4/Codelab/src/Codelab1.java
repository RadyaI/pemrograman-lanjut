import java.util.Scanner;

public class Codelab1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan sebuah kalimat: ");
        String kalimat = input.nextLine().trim();

        String[] kata = kalimat.split("\\s+");
        String kataKedua = (kata.length >= 2) ? kata[1] : "(tidak ada kata kedua)";
        String hurufKapital = kalimat.toUpperCase();
        boolean mengandungJava = kalimat.toLowerCase().contains("java");

        System.out.print("Masukkan kata/kalimat tambahan di akhir: ");
        String tambahan = input.nextLine().trim();
        String gabungan = kalimat + " " + tambahan;
        String kalimatTerbalik = new StringBuilder(gabungan).reverse().toString();

        System.out.println("\n=== HASIL OLAHAN STRING ===");
        System.out.println("Kata kedua: " + kataKedua);
        System.out.println("Huruf kapital : " + hurufKapital);
        System.out.println("Apakah mengandung kata 'java'? : " + mengandungJava);
        System.out.println("Setelah menambah kata: " + gabungan);
        System.out.println("Kalimat terbalik: " + kalimatTerbalik);

        input.close();
    }
}
