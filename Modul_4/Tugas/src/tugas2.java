import java.util.Locale;
import java.util.Scanner;
import java.util.Currency;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tugas2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan jumlah uang: ");
        double jumlah = in.nextDouble();
        in.nextLine();

        System.out.print("Masukkan   tanggal (dd-MM-yyyy): ");
        String tIn = in.nextLine();

        Date tgl = new SimpleDateFormat("dd-MM-yyyy").parse(tIn);

        Locale[] list = {
                new Locale("ko", "KR"),
                Locale.GERMANY,
                Locale.US
        };

        for (Locale l : list) {
            Currency cur = Currency.getInstance(l);
            NumberFormat nf = NumberFormat.getCurrencyInstance(l);
            SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy", l);

            System.out.println("\n=== Locale: " + l.toString() + " ===");
            System.out.println("Country: " + l.getDisplayCountry(l));
            System.out.println("Currency Code: " + cur.getCurrencyCode());
            System.out.println("Currency Symbol: " + cur.getSymbol(l));
            System.out.println("Formatted currency: " + nf.format(jumlah));
            System.out.println("Formatted date: " + df.format(tgl));
        }
    }
}
