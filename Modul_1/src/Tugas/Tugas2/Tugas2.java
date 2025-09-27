package Tugas.Tugas2;
import java.util.Scanner;

public class Tugas2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan angka positif: ");
            int input = scanner.nextInt();

            if (input <= 0) {
                throw new InvalidNumberException("Error: Angka harus positif lebih dari 0!");
            }

            System.out.println("Valid! Angka yang dimasukkan: " + input);

        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Input tidak valid! Harus berupa angka.");
        }

        scanner.close();

    }
}
