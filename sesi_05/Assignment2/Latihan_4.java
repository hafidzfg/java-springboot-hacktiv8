package Assignment2;

import java.util.Scanner;

public class Latihan_4 {
    public static void main(String[] args) {
        // buat variable
        Scanner scan = new Scanner(System.in);

        System.out.println("Masukkan tahun: ");
        int tahun = scan.nextInt();

        // tutup scanner
        scan.close();

        // pengecekan tahun kabisat
        if (tahun % 4 == 0) {
            System.out.println(tahun + " adalah tahun kabisat");
        } else {
            System.out.println(tahun + " bukan tahun kabisat");
        }
    }

}
