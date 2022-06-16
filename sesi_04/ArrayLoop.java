import java.util.Scanner;

public class ArrayLoop {
    public static void main(String[] args) {
        // create array
        String[] itprofesi = new String[5];

        // membuat scanner
        Scanner scan = new Scanner(System.in);

        // put data into array

        for (int i = 0; i < itprofesi.length; i++) {
            System.out.println("Buah ke-" + i + ": ");
            itprofesi[i] = scan.nextLine();
        }

        System.out.println("-----------------------------");

        // print array
        for (String b : itprofesi) {
            System.out.println(b);
        }

        scan.close();

    }
}
