import java.util.Scanner;

public class ArrayLoop {
    public static void main(String[] args) {
        // create array
        String[] buah = new String[5];

        // membuat scanner
        Scanner scan = new Scanner(System.in);

        // put data into array

        for (int i = 0; i < buah.length; i++) {
            System.out.println("Buah ke-" + i + ": ");
            buah[i] = scan.nextLine();
        }

        System.out.println("-----------------------------");

        // print array
        for (String b : buah) {
            System.out.println(b);
        }

        scan.close();

    }
}
