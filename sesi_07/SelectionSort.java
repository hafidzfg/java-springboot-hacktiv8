import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        // create scanner object
        Scanner scan = new Scanner(System.in);

        // input jumlah data
        System.out.print("Masukkan jumlah data: ");
        int jmlData = scan.nextInt();

        // input nilai tiap data
        int[] data = new int[jmlData];
        System.out.println();
        for (int x = 0; x < jmlData; x++) {
            System.out.print("Input nilai data ke-" + (x + 1) + ": ");
            data[x] = scan.nextInt();
        }

        // output data before sorting
        System.out.println();
        System.out.print("Data sebelum sorting: ");
        for (int i = 0; i < jmlData; i++) {
            System.out.print(data[i] + " ");
        }

        // selection sort
        System.out.println("\n\n Proses Selection Sort");
        for (int i = 0; i < jmlData - 1; i++) {
            System.out.println("Interasi ke-" + (i + 1) + ": ");
            for (int y = 0; y < jmlData; y++)
                System.out.print(data[y] + " ");

            System.out.println("   Apakah data " + data[i] + " sudah benar pada urutannya?");

            boolean tukar = false;
            int index = 0;
            int min = data[i];
            String pesan = "   tidak ada pertukaran";
            for (int y = i + 1; y < jmlData; y++) {
                if (min > data[y]) {
                    tukar = true;
                    index = y;
                    min = data[y];
                }

            }
            if (tukar == true) {
                // pertukaran data
                pesan = "   Data " + data[i] + " ditukar dengan data " + data[index];
                int temp = data[i];
                data[i] = data[index];
                data[index] = temp;
            }

            for (int y = 0; y < jmlData; y++)
                System.out.print(data[y] + " ");

            System.out.println(pesan + "\n");
        }

        // output data setelah proses sorting
        System.out.print("Data setelah disorting: ");
        for (int i = 0; i < jmlData; i++)
            System.out.print(data[i] + " ");
        scan.close();
    }

}
