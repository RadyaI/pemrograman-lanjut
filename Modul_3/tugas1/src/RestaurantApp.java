import java.util.Scanner;

public class RestaurantApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();
        menu.addMenuItem(new MenuItem("Nasi Goreng", 20000));
        menu.addMenuItem(new MenuItem("Mie Goreng", 15000));
        menu.addMenuItem(new MenuItem("Es Teh", 5000));

        Order order = new Order();

        boolean tambah = true;
        while(tambah) {
            menu.displayMenu();
            System.out.print("Pilih menu (angka): ");
            int pilihan = scanner.nextInt() - 1;

            if(pilihan >= 0 && pilihan < menu.size()) {
                System.out.print("Jumlah: ");
                int qty = scanner.nextInt();

                order.addItem(new OrderItem(menu.getMenuItem(pilihan), qty));
            } else {
                System.out.println("Pilihan tidak valid!");
            }

            System.out.print("Tambah menu lagi? (y/n): ");
            String lagi = scanner.next();
            if(lagi.equalsIgnoreCase("n")) {
                tambah = false;
            }
        }

        System.out.println();
        order.printReceipt();
    }
}
