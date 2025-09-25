public class CodeLab1 {
    public static void main(String[] args) {
        String[] nama = {"Adi", "Budi", "Cahyo", "Diana", "Eva"};
        cariNamaTerpanjang(nama);
    }

    public static void cariNamaTerpanjang(String[] array) {
        if(array.length == 0){
            System.out.println("Arraynya ga ada isinya");
            return;
        }

        //Di tambah ini
        int maxLength = 0;
        for (String nama : array) {
            if (nama.length() > maxLength) {
                maxLength = nama.length();
            }
        }

        // Munculin semua orang yang namanya panjang
        System.out.print("Nama terpanjang adalah: ");
        for (String nama : array) {
            if (nama.length() == maxLength) {
                System.out.print(nama + " ");
            }
        }

    }
}