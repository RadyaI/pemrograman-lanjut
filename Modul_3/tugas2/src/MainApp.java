import java.util.Scanner;
/**
 * Kelas MainApp menjalankan aplikasi Split Bill.
 * Aplikasi ini memungkinkan user untuk membagi tagihan
 * antara beberapa orang, baik secara rata maupun sesuai porsi.
 *
 * Cara penggunaan:
 * 1. Jalankan aplikasi
 * 2. Pilih mode pembagian tagihan (1 = rata, 2 = sesuai porsi)
 * 3. Masukkan total tagihan dan jumlah orang
 * 4. Masukkan nama dan jumlah bayar masing-masing orang (sesuai mode)
 * 5. Hasil pembagian tagihan akan ditampilkan
 */
public class MainApp {

    /**
     * Method utama yang menjalankan aplikasi Split Bill.
     *
     * @param args Argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("===== SPLIT BILL APP =====");
        System.out.println("1. Sama Rata");
        System.out.println("2. Sesuai Porsi");
        System.out.print("Pilih mode (1/2/3): ");
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
