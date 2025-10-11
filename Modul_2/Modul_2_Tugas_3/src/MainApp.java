import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("===== SPLIT BILL APP =====");
        System.out.println("1. Sama Rata");
        System.out.println("2. Sesuai Porsi");
        System.out.print("Pilih mode (1/2): ");
        int mode = input.nextInt();
        input.nextLine();

        System.out.print("Masukkan total tagihan: ");
        double totalBill = input.nextDouble();
        System.out.print("Masukkan jumlah orang: ");
        int count = input.nextInt();
        input.nextLine();

        BillCalculator calc = new BillCalculator(totalBill, count, mode);
        calc.inputNamesAndAmounts();
        calc.showResult();

        input.close();
    }
}
