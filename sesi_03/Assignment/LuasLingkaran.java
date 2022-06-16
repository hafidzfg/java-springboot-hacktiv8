package Assignment;

import java.util.Scanner;

public class LuasLingkaran {
    public static void main(String[] args) {
        System.out.println("------Ini Assigment 1------");
        Scanner scan = new Scanner(System.in);

        System.out.println("Masukkan jari-jari lingkaran (cm):");

        double L, phi = 3.14;
        int r = scan.nextInt();
        scan.close();

        L = phi * r * r;

        System.out.println("Luas lingkaran: " + L + " cm^2");
    }
}
