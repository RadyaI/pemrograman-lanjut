import java.util.Scanner;

public class BillCalculator implements SplitOperation {
    public double totalBill;
    public int totalPeople;
    public Person[] persons;
    public int mode; // 1 = sama rata, 2 = sesuai porsi

    public BillCalculator(double total, int count, int m) {
        totalBill = total;
        totalPeople = count;
        mode = m;
        persons = new Person[count];
    }

    public void inputNamesAndAmounts() {
        Scanner sc = new Scanner(System.in);

        if (mode == 1) {
            samaRata(sc);
        } else if (mode == 2) {
            sesuaiPorsi(sc);
        }
    }

    @Override
    public void sesuaiPorsi(Scanner sc) {
        double totalInput = 0;
        for (int i = 0; i < totalPeople; i++) {
            System.out.print("Masukkan nama orang ke-" + (i + 1) + ": ");
            String n = sc.nextLine();
            System.out.print("Masukkan jumlah bayar " + n + ": ");
            double a = sc.nextDouble();
            sc.nextLine();
            persons[i] = new Person(n, a);
            totalInput = totalInput + a;
        }

        if (Math.abs(totalInput - totalBill) > 0.001) {
            System.out.println("\n⚠️ Total yang diinput (" + totalInput +
                    ") tidak sesuai dengan total tagihan (" + totalBill + ")!");
        } else {
            System.out.println("\n✅ Total pembayaran sesuai!");
        }
    }

    @Override
    public void samaRata(Scanner sc) {
        for (int i = 0; i < totalPeople; i++) {
            System.out.print("Masukkan nama orang ke-" + (i + 1) + ": ");
            String n = sc.nextLine();
            persons[i] = new Person(n, totalBill / totalPeople);
        }
    }

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
