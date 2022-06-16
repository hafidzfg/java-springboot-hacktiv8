import java.util.LinkedList;

public class linkedList {
    public static void main(String[] args) {
        // create instance/object of LinkedList
        LinkedList<String> barang = new LinkedList<>();

        // add data tp object
        barang.add("Laptop");
        barang.add("Komputer");
        barang.add("Radio");
        barang.addLast("Sepeda");

        if (barang.isEmpty()) {
            System.out.println("data kosong");
        } else {
            System.out.println("data isi");
        }

        if (barang.contains("Laptop")) {
            System.out.println("Laptop ketemu");
        } else {
            System.out.println("Laptop is missing");
        }

        System.out.println(barang);

        barang.removeFirst();

        System.out.println(barang);

        barang.set(0, "Becak");

        System.out.println(barang);

    }

}
