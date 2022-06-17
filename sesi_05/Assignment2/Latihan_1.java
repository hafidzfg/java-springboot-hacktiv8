package Assignment2;

import java.util.Scanner;

public class Latihan_1 {

    static int maxNumber(int x, int y, int z) {
        // method sama param berbeda
        // double data type
        if (x > y && x > z) {
            return x;
        } else if (y > x && y > z) {
            return y;
        } else {
            return z;
        }
    }

    static int minNumber(int x, int y, int z) {
        // method sama param berbeda
        // double data type
        if (x < y && x < z) {
            return x;
        } else if (y < x && y < z) {
            return y;
        } else {
            return z;
        }
    }

    static double average(int x, int y, int z) {
        // method sama param berbeda
        // double data type
        return (double) (x + y + z) / 3;
    }

    public static void main(String[] args) {
        int x, y, z;
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan nilai x: ");
        x = scan.nextInt();

        System.out.print("Masukkan nilai y: ");
        y = scan.nextInt();

        System.out.print("Masukkan nilai z: ");
        z = scan.nextInt();

        System.out.println("Rata-ratanya: " + average(x, y, z));
        System.out.println(maxNumber(x, y, z) + " adalah bilangan terbesar.");
        System.out.println(minNumber(x, y, z) + " adalah bilangan terkecil.");

        scan.close();

    }

}
