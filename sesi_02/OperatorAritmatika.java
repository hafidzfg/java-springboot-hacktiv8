import java.util.Scanner;

public class OperatorAritmatika {
    public static void main(String[] args) {
        int angka1, angka2, hasil;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Input angka-1: ");
        angka1 = keyboard.nextInt();
        System.out.println("Input angka-2: ");
        angka2 = keyboard.nextInt();

        // penjumlahan
        hasil = angka1 + angka2;
        System.out.println("Penjumlahan: " + hasil);

        System.out.println("Input angka");

        System.out.println("Input angka-1: ");
        angka1 = keyboard.nextInt();
        System.out.println("Input angka-2: ");
        angka2 = keyboard.nextInt();

        // pengurangan
        hasil = angka1 - angka2;
        System.out.println("pengurangan: " + hasil);

        System.out.println("Input angka-1: ");
        angka1 = keyboard.nextInt();
        System.out.println("Input angka-2: ");
        angka2 = keyboard.nextInt();

        // perkalian
        hasil = angka1 * angka2;
        System.out.println("perkalian: " + hasil);

        System.out.println("Input angka-1: ");
        angka1 = keyboard.nextInt();
        System.out.println("Input angka-2: ");
        angka2 = keyboard.nextInt();

        // pembagian
        hasil = angka1 / angka2;
        System.out.println("pembagian: " + hasil);

        System.out.println("Input angka-1: ");
        angka1 = keyboard.nextInt();
        System.out.println("Input angka-2: ");
        angka2 = keyboard.nextInt();
        keyboard.close();

        // sisa bagi
        hasil = angka1 % angka2;
        System.out.println("sisa bagi: " + hasil);

    }
}
