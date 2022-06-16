import java.util.Scanner;

public class Hadiah {
    public static void main(String[] args) {
        // create variable belanja and scanner
        int belanja = 0;
        Scanner scan = new Scanner(System.in);

        // take input
        System.out.println("Total belanjaan: Rp ");
        belanja = scan.nextInt();

        scan.close();

        // cek apakah belanjaan lebih dari Rp100000
        if (belanja > 100000) {
            System.out.println("Selamat, anda mendapatkan hadiah!");
        }

        System.out.println("Terima kasih!");
    }
}
