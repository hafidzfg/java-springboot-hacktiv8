public class OperatorBitwise {

    public static void main(String[] args) {
        int x = 2, y = 1, hasil = 0;

        hasil = x & y;
        System.out.println("x & y = " + hasil);

        hasil = x | y;
        System.out.println("x | y = " + hasil);

        hasil = x ^ y;
        System.out.println("x ^ y = " + hasil);

        hasil = ~x;
        System.out.println("~x = " + hasil);

        hasil = x >> 2;
        System.out.println("x >> 2 = " + hasil);

        hasil = x << 2;
        System.out.println("x << 2 = " + hasil);

        hasil = x >>> 2;
        System.out.println("x >>> 2 = " + hasil);
    }

}
