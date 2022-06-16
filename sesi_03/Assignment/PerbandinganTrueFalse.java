package Assignment;

public class PerbandinganTrueFalse {
    public static void main(String[] args) {
        System.out.println("\n------Ini Assigment 4------");

        // create variables
        int a = 10;
        int b = 8;
        int c = 12;
        int d = 5;

        System.out.println("Tes ke 1 = " + (a > b)); // true
        System.out.println("Tes ke 2 = " + (b < a)); // true
        System.out.println("Tes ke 3 = " + (c >= d)); // true
        System.out.println("Tes ke 4 = " + (d <= c)); // true
        System.out.println("Tes ke 5 = " + (a - b == c - a)); // true
        System.out.println("Tes ke 6 = " + (a - b != c + d)); // true
        System.out.println("Tes ke 7 = " + (c + d > a + b)); // false
        System.out.println("Tes ke 8 = " + (a * b <= c * d)); // false
        System.out.println("Tes ke 9 = " + (a % b == c % b)); // false
        System.out.println("Tes ke 10 = " + (a % b != c % d)); // false
    }
}
