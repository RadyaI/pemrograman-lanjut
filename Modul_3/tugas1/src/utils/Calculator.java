package utils;

public class Calculator {

    public static double calculateTax(double total) {
        return total * 0.10;
    }

    public static double calculateDiscount(double total) {
        if (total > 100000) {
            return total * 0.05;
        }
        return 0;
    }
}
