package Polymorphism;

public class AnakHilang extends Emak implements JuaraKelas {
    @Override
    public void siapa() {
        System.out.println("Namanya: " + nama);
    }
}
