public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hi");
        var x = 5;
        var y = 7;
        var z = x + y;
        System.out.println(z);

        if (z == 12) {
            System.out.println("True");
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Perulangan ke: " + i);

        }
    }
}