import java.util.Scanner;

public class Codelab1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan sebuah kalimat: ");
        String kalimat = input.nextLine().trim();

        String[] kata = kalimat.split("\\s+");
        String kataKedua = (kata.length >= 2) ? kata[1] : "(tidak ada kata kedua)";
        System.out.println("Kata kedua: " + kataKedua);

        String hurufKapital = kalimat.toUpperCase();
        System.out.println("Huruf kapital : " + hurufKapital);

        boolean mengandungJava = kalimat.toLowerCase().contains("java");
        System.out.println("Apakah mengandung kata 'java'? : " + mengandungJava);

        System.out.print("Masukkan kata/kalimat tambahan di akhir: ");
        String tambahan = input.nextLine().trim();
        String gabungan = kalimat + " " + tambahan;
        System.out.println("Setelah menambah kata: " + gabungan);

        StringBuilder pembalik = new StringBuilder(gabungan);
        String kalimatTerbalik = pembalik.reverse().toString();
        System.out.println("Kalimat terbalik: " + kalimatTerbalik);

        input.close();
    }
}
