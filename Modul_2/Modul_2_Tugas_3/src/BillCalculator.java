import java.util.Scanner;

public class BillCalculator {
    public static final double SELISIH = 0.001;
    public double t_Bill;
    public int t_People;
    public Person[] persons;
    public int mode; // 1 = sama rata, 2 = sesuai porsi

    public BillCalculator(double total, int count, int m) {
        t_Bill = total;
        t_People = count;
        mode = m;
        persons = new Person[count];
    }

    public void inputNamesAndAmounts() {
        Scanner sc = new Scanner(System.in);

        if (mode == 1) {
            double share = t_Bill / t_People;
            for (int i = 0; i < t_People; i++) {
                System.out.print("Masukkan nama orang ke-" + (i + 1) + ": ");
                String n = sc.nextLine();
                persons[i] = new Person(n, share);
            }
        } else if (mode == 2) {
            double totalInput = 0;
            for (int i = 0; i < t_People; i++) {
                System.out.print("Masukkan nama orang ke-" + (i + 1) + ": ");
                String n = sc.nextLine();
                System.out.print("Masukkan jumlah bayar " + n + ": ");
                double a = sc.nextDouble();
                sc.nextLine();
                persons[i] = new Person(n, a);
                totalInput = totalInput + a;
            }

            if (Math.abs(totalInput - t_Bill) > SELISIH) {
                System.out.println("\n⚠️ Total yang diinput (" + totalInput +
                        ") tidak sesuai dengan total tagihan (" + t_Bill + ")!");
            } else {
                System.out.println("\n✅ Total pembayaran sesuai!");
            }
        }
    }

    public void showResult() {
        System.out.println("\n===== HASIL SPLIT BILL =====");
        System.out.println("Total tagihan: Rp " + t_Bill);
        System.out.println("Jumlah orang: " + t_People);
        System.out.println();

        for (int i = 0; i < t_People; i++) {
            System.out.printf("%s membayar Rp %.0f%n", persons[i].name, persons[i].amount);
        }
    }
}
