import java.util.Random;
import java.util.Scanner;

public class Codelab2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random acak = new Random();
        int pilihan;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Buat bilangan bulat acak");
            System.out.println("2. Ambil karakter acak dari string");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");

            while (!in.hasNextInt()) {
                System.out.print("Masukkan angka antara 1-3: ");
                in.next();
            }
            pilihan = in.nextInt();
            in.nextLine();

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Masukkan nilai minimum: ");
                    int min = in.nextInt();
                    System.out.print("Masukkan nilai maksimum: ");
                    int max = in.nextInt();
                    in.nextLine();

                    if (min > max) {
                        System.out.println("Rentang tidak valid (min > max).");
                    } else {
                        int hasil = acak.nextInt(max - min + 1) + min;
                        System.out.println("Bilangan acak antara " + min + " dan " + max + " : " + hasil);
                    }
                }

                case 2 -> {
                    System.out.print("Masukkan sebuah kalimat: ");
                    String kalimat = in.nextLine().trim();
                    if (kalimat.isEmpty()) {
                        System.out.println("String kosong, tidak bisa diambil karakter.");
                    } else {
                        int indeks = acak.nextInt(kalimat.length());
                        char karakter = kalimat.charAt(indeks);
                        System.out.println("Karakter acak dari string: " + karakter);
                    }
                }

                case 3 -> System.out.println("Program selesai. Terima kasih!");

                default -> System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (pilihan != 3);

        in.close();
    }
}