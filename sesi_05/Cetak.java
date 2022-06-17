abstract class Manusia {
    // declare class and method with abstract type
    protected abstract void nyanyiLagu();
}

class Cowok extends Manusia {
    // use methode from abstra class manusia
    @Override
    protected void nyanyiLagu() {
        System.out.println("na na na na na");
        // statement dari perilaku yang memberikaan output berbeda dari class manusia
    }
}

class Cewek extends Manusia {
    // use method from abstract class manusia
    @Override
    protected void nyanyiLagu() {
        System.out.println("du di du di dam dam");
    }
}

public class Cetak {
    static double maxNumber(double a, double b) {
        // method sama param berbeda
        // double data type
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    static int maxNumber(int a, int b) {
        // method sama parameter berbeda
        // double data type
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        // create object with reference manusia class, with cons cowok
        Manusia cowok = new Cowok();

        // output pada method yang ada di class cowok
        cowok.nyanyiLagu();

        // buat object referensi clas manusia, cons cewek
        Manusia cewek = new Cewek();

        // output method from class cewek
        cewek.nyanyiLagu();

        System.out.println("double: " + maxNumber(7.5, 200));
        System.out.println("int: " + maxNumber(5, 4));

    }

}
