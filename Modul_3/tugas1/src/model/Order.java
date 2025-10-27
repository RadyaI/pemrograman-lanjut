package model;

import utils.Calculator;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
    }

    public double getTotalBeforeTax() {
        double total = 0;
        for (OrderItem item : orderItems) {
            total += item.getSubtotal();
        }
        return total;
    }

    public double getTax() {
        return Calculator.calculateTax(getTotalBeforeTax());
    }

    public double getDiscount() {
        return Calculator.calculateDiscount(getTotalBeforeTax());
    }

    public double getFinalTotal() {
        return getTotalBeforeTax() + getTax() - getDiscount();
    }

    public void printReceipt() {
        System.out.println("\n======= Receipt =======");
        for (OrderItem item : orderItems) {
            System.out.println(item);
        }
        System.out.println("---------------------------------");
        System.out.println("Subtotal: Rp" + getTotalBeforeTax());
        System.out.println("Tax (10%): Rp" + getTax());
        System.out.println("Discount: Rp" + getDiscount());
        System.out.println("Total: Rp" + getFinalTotal());
        System.out.println("=================================");
    }
}
