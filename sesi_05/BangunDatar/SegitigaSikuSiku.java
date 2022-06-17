package BangunDatar;

public class SegitigaSikuSiku extends BangunDatar {
    float alas, tinggi;

    float sisiMiring = (float) Math.sqrt(Math.pow(alas, 2) + Math.pow(tinggi, 2));

    float luas() {
        return luas = alas * tinggi / 2;
    }

    float keliling() {
        return keliling = sisiMiring + alas + tinggi;
    }
}
