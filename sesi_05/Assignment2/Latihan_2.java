package Assignment2;

public class Latihan_2 {
    public static void main(String[] args) {
        String[][] posisi = { { "php", "ruby", "java" }, { "golang", "javascript", "swift" }, {} };

        System.out.println("==============================");
        for (int x = 0; x < posisi.length - 1; x++) {
            for (int y = 0; y < posisi.length; y++) {
                System.out.print("|" + posisi[x][y] + "|");
                System.out.print("   ");

                if (x == 0 && y == 2)
                    System.out.println("");

            }
        }
        System.out.println("\n==============================");
    }
}
