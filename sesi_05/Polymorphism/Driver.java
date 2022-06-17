package Polymorphism;

public class Driver {
    public static void main(String[] args) {
        // bentuk #1 (class sendiri)
        AnakHilang i = new AnakHilang();
        i.siapa();
        i.tidur();

        // bentuk #2 (class lain)
        Emak anak1 = new AnakHilang();
        System.out.println(anak1.pendidikan);

        // bentuk #3 (interface)
        JuaraKelas anak2 = new AnakHilang();
        anak2.jalan();
    }

}
