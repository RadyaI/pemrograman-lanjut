/**
 * Kelas Person merepresentasikan seorang individu dalam
 * pembagian tagihan, dengan nama dan jumlah bayar.
 */
public class Person {
    /** Nama orang */
    private String name;

    /** Jumlah yang harus dibayar */
    private double amount;

    /**
     * Konstruktor Person.
     *
     * @param n Nama orang
     * @param a Jumlah bayar
     */
    public Person(String n, double a) {
        setName(n);
        setAmount(a);
    }

    /**
     * Mendapatkan nama orang.
     *
     * @return nama orang
     */
    public String getName() {
        return name;
    }

    /**
     * Mengatur nama orang.
     *
     * @param name Nama orang
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Mendapatkan jumlah bayar orang.
     *
     * @return jumlah bayar
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Mengatur jumlah bayar orang.
     *
     * @param amount Jumlah bayar
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
