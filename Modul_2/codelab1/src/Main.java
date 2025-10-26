public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "J.K. Rowling", 10, 2);
        Library lib = new Library(book1, "Perpustakaan Kota");

        lib.showLibraryInfo();

        book1.adjustStock(5);

        lib.showLibraryInfo();
    }
}
