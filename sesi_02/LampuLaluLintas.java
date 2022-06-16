import java.util.Scanner;

public class LampuLaluLintas {
    public static void main(String[] args) {
        String lampu;
        Scanner scan = new Scanner(System.in);

        System.out.println("What's the color?:");
        lampu = scan.nextLine();
        scan.close();

        switch (lampu) {
            case "red":
                System.out.println("It's red, stop!");
                break;
            case "yellow":
                System.out.println("It's yellow, careful!");
                break;
            case "green":
                System.out.println("It's green, go!");
                break;
            default:
                System.out.println("Wrong traffic light color");
        }
    }

}
