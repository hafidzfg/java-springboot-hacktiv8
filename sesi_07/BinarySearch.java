import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int c, first, last, middle, n, search, array[];
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number of elements");

        n = scan.nextInt();
        array = new int[n];

        System.out.println("Enter " + n + " integers");
        for (c = 0; c < n; c++) {
            array[c] = scan.nextInt();
        }

        System.out.print("Array kamu: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("\nEnter a value to find");
        search = scan.nextInt();

        first = 0;
        last = n - 1;
        middle = (first + last) / 2;
        while (first <= last) {
            if (array[middle] < search) {
                first = middle + 1;
            } else if (array[middle] == search) {
                System.out.println(search + " found at location " + (middle + 1) + ".");
                break;
            } else {
                last = middle - 1;
            }
            middle = (first + last) / 2;
        }
        if (first > last) {
            System.out.println(search + " is not present on the list.\n");
        }
        scan.close();

    }

}
