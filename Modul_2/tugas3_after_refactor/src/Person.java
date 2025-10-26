public class Person {
    private String name;
    private double amount;

    public Person(String n, double a) {
        setName(n);
        setAmount(a);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
