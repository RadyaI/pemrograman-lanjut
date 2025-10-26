import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("=== Nota Pemesanan ===");
        for (OrderItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total: " + calculateTotal());
    }
}
