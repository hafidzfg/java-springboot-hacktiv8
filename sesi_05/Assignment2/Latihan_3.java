package Assignment2;

import java.util.Scanner;

public class Latihan_3 {

    public static void main(String[] args) {
        // buat variable
        float pembelian, hargaBayar, diskon;
        Scanner scan = new Scanner(System.in);

        // Berikan input kepada pembelian
        System.out.println("Masukkan harga pembelian kamu (Rp): ");
        pembelian = scan.nextInt();

        // close scan
        scan.close();

        // syarat diskon
        if (pembelian >= 1000000) {
            diskon = 0.05f;
        } else {
            diskon = 0;
        }

        // total hargaBayar setelah diskon
        hargaBayar = pembelian - pembelian * diskon;

        System.out.println("Total belanja kamu: Rp" + hargaBayar);

    }

}
