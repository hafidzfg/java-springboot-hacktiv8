class Nilai {
    public static void main(String[] args) {
        cetakNilai(5, 6);
        Nilai nilai = new Nilai(11, 11);
        cetakNilai(nilai.num1, nilai.num2);
    }

    int num1;
    int num2;

    Nilai(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    static void cetakNilai(int num1, int num2) {
        System.out.println("(" + num1 + "," + num2 + ")");
    }

    Nilai center(Nilai other) {
        // mengendalikan result antara this nilai dengan nilai other
        // hasilnya tidak begitu akurat karena tipe data integer
        return new Nilai((num1 + other.num1) / 2, (num2 + other.num2) / 2);
    }

}
