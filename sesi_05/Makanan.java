public class Makanan {
    public static void main(String[] args) {
        // create instance/object from restoran class
        Restoran data = new Restoran();

        // buat data pada variabel
        data.setMenu("Ayam Goreng");
        data.setHarga(17000);
        data.setSpesial(true);

        System.out.println("Menu makanan: " + data.getMenu());
        System.out.println("Harga makanan: " + data.getHarga());
        System.out.println("Menu spesial: " + data.getSpesial());
    }

}
