import java.util.Scanner;

public class CekKelulusan {
    public static void main(String[] args) {
        int nilai;
        String nama;
        Scanner scan = new Scanner(System.in);

        // take input
        System.out.println("Nama: ");
        nama = scan.nextLine();

        System.out.println("Nilai: ");
        nilai = scan.nextInt();

        scan.close();

        // cek apakah lulus atau tidak
        if (nilai >= 75) {
            System.out.println("Selamat " + nama + ", anda lulus!");
        } else {
            System.out.println("Maaf " + nama + ", kamu harus remidi!");
        }

    }

}
