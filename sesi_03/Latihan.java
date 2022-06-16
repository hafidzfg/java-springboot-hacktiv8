import java.util.Scanner;

public class Latihan {
    public static void main(String[] args) {
        // latihan1 bintang
        bintang(args);
        sepuluh(args);
        ganjilSaja(args);
        LatihanWhile(args);

    }

    public static void bintang(String[] args) {
        System.out.println("-------Latihan 1-------");
        for (int i = 0; i < 6; i++) {
            for (int k = 6; k > 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void sepuluh(String[] args) {
        System.out.println("-------Latihan 2-------");
        for (int i = 0; i < 11; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void ganjilSaja(String[] args) {
        System.out.println("-------Latihan 3-------");
        for (int i = 0; i <= 20; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }

        }
    }

    public static void LatihanWhile(String[] args) {

        System.out.println("\n-------Latihan 4-------");
        System.out.println("Ingin ngulang berapa kali?");

        Scanner scan = new Scanner(System.in);

        int i = 0;
        int k = scan.nextInt();
        scan.close();

        while (i <= k) {
            System.out.println("Perulangan ke-" + i);
            i++;
        }

    }

}
