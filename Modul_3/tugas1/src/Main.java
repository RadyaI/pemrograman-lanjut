import model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Order order = new Order();

        List<MenuItem> menu = List.of(
                new MenuItem("Nasi Goreng Spesial", 25000),
                new MenuItem("Mie Ayam Komplit", 20000),
                new MenuItem("Es Teh Manis", 8000),
                new MenuItem("Jus Alpukat", 15000),
                new MenuItem("Ayam Geprek", 22000)
        );

        System.out.println("=== Selamat Datang di DineSmart ===");
        String next;
        do {
            System.out.println("\nDaftar Menu:");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i));
            }

            System.out.print("Pilih nomor menu: ");
            int menuChoice = input.nextInt();

            System.out.print("Jumlah: ");
            int quantity = input.nextInt();

            if (menuChoice > 0 && menuChoice <= menu.size()) {
                order.addOrderItem(new OrderItem(menu.get(menuChoice - 1), quantity));
            } else {
                System.out.println("Menu tidak tersedia!");
            }

            System.out.print("Tambah pesanan lain? (y/n): ");
            next = input.next();
        } while (next.equalsIgnoreCase("y"));

        order.printReceipt();
    }
}
