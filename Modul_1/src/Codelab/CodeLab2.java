import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CodeLab2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan usia Anda: ");
            int usia = input.nextInt();

            if (usia <= 0 || usia >= 120) {
                throw new InvalidAgeException("Usia tidak valid! Usia harus > 0 dan < 120.");
            }

            System.out.println("Usia valid: " + usia);

        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Harus angka");
        }

        input.close();
    }
}