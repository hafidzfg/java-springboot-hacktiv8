public class ContohArray {
    public static void main(String[] args) {
        String[] kucing = { "Pug", "Turtle", "Beluga", "Cow" };

        for (int i = 0; i < kucing.length; i++) {
            System.out.println("Kucing ke-" + (i + 1) + ": " + kucing[i]);
        }
    }
}
