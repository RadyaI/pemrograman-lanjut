import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama kamu: ");
        String nama = input.nextLine();

        System.out.print("Masukkan umur kamu: ");
        int umur = input.nextInt();

        sapaUser(nama);
        cekUmur(umur);

        input.close();
    }

    public static void sapaUser(String nama) {
        System.out.println("\nHalo, " + nama + "!");
    }

    public static void cekUmur(int umur) {
        if (umur >= 18) {
            System.out.println("Kamu sudah dewasa.");
        } else {
            System.out.println("Kamu masih remaja.");
        }
    }
}
