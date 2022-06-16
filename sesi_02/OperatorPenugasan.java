public class OperatorPenugasan {
    public static void main(String[] args) {
        int a;
        int b;

        a = 5;
        b = 10;

        // penambahan;
        b += a; // b = 15
        System.out.println("Penambahan: " + b);

        // pengurangan;
        b -= a; // b = 10
        System.out.println("Pengurangan: " + b);

        // perkalian;
        b *= a; // b = 50
        System.out.println("Perkalian: " + b);

        // pembagian;
        b /= a; // b = 10
        System.out.println("Pembagian: " + b);

        // sisa bagi;
        b %= a; // b = 0
        System.out.println("Sisa bagi: " + b);
    }

}
