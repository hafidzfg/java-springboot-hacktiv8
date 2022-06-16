import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {
        boolean seger = true;
        int i = 0;
        String jawab;
        Scanner scan = new Scanner(System.in);

        while (seger) {
            System.out.println("Apakah anda ingin tidur? (y/n)");

            jawab = scan.nextLine();
            scan.close();

            if (jawab.equalsIgnoreCase("y")) {
                seger = false;
            }
            i++;
        }
        System.out.println("Anda sudah tidur selama " + i + " jam");
    }

}
