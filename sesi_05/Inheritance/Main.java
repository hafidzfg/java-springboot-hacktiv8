package Inheritance;

public class Main {
    public static void main(String[] args) {
        // create objek lingkaran dan mengisi nilai properti
        Lingkaran lingkaran = new Lingkaran();
        lingkaran.r = 13;

        System.out.println("\nLuas lingkaran: " + lingkaran.luas());
        System.out.println("Keliling lingkaran: " + lingkaran.keliling());

        // create objek Persegi Panjang dan isi nilai properti
        PersegiPanjang persegiPanjang = new PersegiPanjang();
        persegiPanjang.panjang = 8;
        persegiPanjang.lebar = 4;

        System.out.println("\nLuas Persegi panjang: " + persegiPanjang.luas());
        System.out.println("Keliling Persegi panjang: " + persegiPanjang.keliling());

        // create object Segitiga dan isi nilai properti
        SegitigaSikuSiku mSegitiga = new SegitigaSikuSiku();
        mSegitiga.alas = 12;
        mSegitiga.tinggi = 8;

        System.out.println("\nLuas mSegitiga: " + mSegitiga.luas());
        System.out.println("Keliling mSegitiga: " + mSegitiga.keliling());

        // create object Persegi dan isi nilai properti
        Persegi persegi = new Persegi();
        persegi.sisi = 10;

        System.out.println("\nLuas persegi: " + persegi.luas());
        System.out.println("Keliling persegi: " + persegi.keliling());

        // Persegi k = new Keliling();
        // Persegi l = new Luas();
    }

}
