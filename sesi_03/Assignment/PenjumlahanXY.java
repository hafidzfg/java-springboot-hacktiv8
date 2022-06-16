package Assignment;

public class PenjumlahanXY {
    public static void main(String[] args) {
        System.out.println("\n------Ini Assigment 5------");
        int x1, x2, y1, y2;

        y1 = 10;
        y2 = 2;

        x1 = y1 + y2;
        x2 = (y1 % 4) * y2;

        System.out.println("x1 >= x2? " + (x1 >= x2)); // true
        System.out.println("x2 >= x1? " + (x2 >= x1)); // false
        System.out.println("x1 % 4 == ++x2 % 5 ? " + (x1 % 4 == ++x2 % 5)); // true
    }
}
