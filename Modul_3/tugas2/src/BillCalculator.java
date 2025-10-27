import java.util.Scanner;

/**
 * Kelas BillCalculator digunakan untuk menghitung pembagian tagihan
 * di antara beberapa orang, baik secara rata maupun sesuai porsi.
 * Mengimplementasikan interface SplitOperation.
 */
public class BillCalculator implements SplitOperation {
    /** Toleransi selisih pembayaran */
    public static final double TOLERANCE = 0.001;

    /** Total tagihan */
    public double totalBill;

    /** Jumlah orang yang membayar */
    public int totalPeople;

    /** Array objek Person yang menyimpan nama dan jumlah bayar */
    public Person[] persons;

    /** Mode pembagian tagihan (1 = rata, 2 = sesuai porsi) */
    public int mode;

    /**
     * Konstruktor BillCalculator.
     *
     * @param total Total tagihan
     * @param count Jumlah orang
     * @param m Mode pembagian (1 = rata, 2 = sesuai porsi)
     */
    public BillCalculator(double total, int count, int m) {
        totalBill = total;
        totalPeople = count;
        mode = m;
        persons = new Person[count];
    }

    /**
     * Input nama dan jumlah bayar masing-masing orang.
     * Memanggil method samaRata() atau sesuaiPorsi() berdasarkan mode.
     */
    public void inputNamesAndAmounts() {
        Scanner sc = new Scanner(System.in);

        if (mode == 1) {
            samaRata(sc);
        } else if (mode == 2) {
            sesuaiPorsi(sc);
        }
    }

    /**
     * Pembagian tagihan sesuai porsi masing-masing orang.
     * Mengecek apakah total input sesuai dengan total tagihan.
     * Akan memvalidasi input agar hanya menerima angka.
     *
     * @param sc Scanner untuk input dari user
     */
    @Override
    public void sesuaiPorsi(Scanner sc) {
        double totalInput = 0;

        for (int i = 0; i < totalPeople; i++) {
            System.out.print("Masukkan nama orang ke-" + (i + 1) + ": ");
            String n = sc.nextLine();

            double a = 0;
            boolean valid = false;
            while (!valid) {
                System.out.print("Masukkan jumlah bayar " + n + ": ");
                if (sc.hasNextDouble()) {
                    a = sc.nextDouble();
                    sc.nextLine();
                    valid = true;
                } else {
                    System.out.println("⚠️ Input tidak valid! Masukkan angka.");
                    sc.nextLine();
                }
            }

            persons[i] = new Person(n, a);
            totalInput += a;
        }

        if (Math.abs(totalInput - totalBill) > TOLERANCE) {
            System.out.println("\n⚠️ Total yang diinput (" + totalInput +
                    ") tidak sesuai dengan total tagihan (" + totalBill + ")!");
        } else {
            System.out.println("\n✅ Total pembayaran sesuai!");
        }
    }
    /**
     * Pembagian tagihan secara rata.
     *
     * @param sc Scanner untuk input dari user
     */
    @Override
    public void samaRata(Scanner sc) {
        for (int i = 0; i < totalPeople; i++) {
            System.out.print("Masukkan nama orang ke-" + (i + 1) + ": ");
            String n = sc.nextLine();
            persons[i] = new Person(n, totalBill / totalPeople);
        }
    }

    /**
     * Menampilkan hasil pembagian tagihan.
     */
    @Override
    public void showResult() {
        System.out.println("\n===== HASIL SPLIT BILL =====");
        System.out.println("Total tagihan: Rp " + totalBill);
        System.out.println("Jumlah orang: " + totalPeople);
        System.out.println();

        for (int i = 0; i < totalPeople; i++) {
            System.out.printf("%s membayar Rp %.0f%n", persons[i].getName(), persons[i].getAmount());
        }
    }
}
