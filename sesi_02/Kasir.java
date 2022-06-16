import java.util.Scanner;

public class Kasir {
    public static void main(String[] args) {
        int invoice, discount, total;
        String card;
        Scanner scan = new Scanner(System.in);

        // get input
        System.out.println("Do you have a member card? (y/n)");
        card = scan.nextLine();
        System.out.println("Total invoice (Rp):");
        invoice = scan.nextInt();
        scan.close();

        if (card.equalsIgnoreCase("y")) {
            if (invoice > 500000) {
                discount = 50000;
            } else if (invoice > 100000) {
                discount = 15000;
            } else {
                discount = 0;
            }
        } else {
            if (invoice > 100000) {
                discount = 5000;
            } else {
                discount = 0;
            }
        }

        total = invoice - discount;

        System.out.println("Your total is: Rp" + total);
    }

}
