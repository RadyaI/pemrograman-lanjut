import java.util.Scanner;

/**
 * Interface SplitOperation mendefinisikan operasi dasar
 * untuk membagi tagihan di antara beberapa orang.
 *
 * Kelas yang mengimplementasikan interface ini harus menyediakan:
 * - Pembagian tagihan sesuai porsi masing-masing orang
 * - Pembagian tagihan secara rata
 * - Menampilkan hasil pembagian tagihan
 */
public interface SplitOperation {

    /**
     * Membagi tagihan sesuai porsi masing-masing orang.
     *
     * @param sc Scanner untuk input dari user
     */
    void sesuaiPorsi(Scanner sc);

    /**
     * Membagi tagihan secara rata di antara semua orang.
     *
     * @param sc Scanner untuk input dari user
     */
    void samaRata(Scanner sc);

    /**
     * Menampilkan hasil pembagian tagihan.
     */
    void showResult();
}
