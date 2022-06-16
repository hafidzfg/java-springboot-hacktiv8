package Assignment;

public class IncrementDecrement {
    public static void main(String[] args) {
        System.out.println("\n------Ini Assigment 3------");

        // create variable
        int a = 0, b = 0, c = 9, d = 9;

        // print ke 1
        System.out.println("Print ke 1");
        System.out.println("A = " + a++); // 0
        System.out.println("C = " + ++b); // 1
        System.out.println("D = " + c--); // 9
        System.out.println("E = " + --d); // 8

        // print ke 2
        System.out.println("Print ke 2");
        System.out.println("A = " + a++); // 1
        System.out.println("C = " + ++b); // 2
        System.out.println("D = " + c--); // 8
        System.out.println("E = " + --d); // 7

        // print ke 2
        System.out.println("Print ke 3");
        System.out.println("A = " + a++); // 2
        System.out.println("C = " + ++b); // 3
        System.out.println("D = " + c--); // 7
        System.out.println("E = " + --d); // 6

        // print ke 2
        System.out.println("Print ke 4");
        System.out.println("A = " + a++); // 3
        System.out.println("C = " + ++b); // 4
        System.out.println("D = " + c--); // 6
        System.out.println("E = " + --d); // 5
    }
}
