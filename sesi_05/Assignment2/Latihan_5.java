package Assignment2;

import java.util.Scanner;

public class Latihan_5 {
    // buat object yang berisi nama barang, harganya, serta diskonnya
    static Object[][] barangs = { { "Apple Watch", 2200000f, 0.1f },
            { "Headphone Eksternal", 246000f, 0.05f },
            { "PowerBank 10.000 mAh", 136000f, 0f }, { "Tripod Kamera", 267999f, 0.2f },
            { "Smart Watch Xiaomi", 899000f, 0.1f } };

    public static void main(String[] args) {
        // buat variabel yang akan dipakai
        int jumlahBeli;
        float totalHarga = 0, subTotalBayar;

        // buat scanner
        Scanner scan = new Scanner(System.in);

        System.out.println("Masukkan jumlah beli: ");

        jumlahBeli = scan.nextInt();

        // buat array untuk menyimpan kode barang yang akan dibeli dan jumlah barang
        // yang akan dibeli
        Integer listBelanja[] = new Integer[jumlahBeli];
        Integer jmlBelanja[] = new Integer[jumlahBeli];

        // looping untuk memasukkan kode barang dan jumlah barang yang akan dibeli ke
        // array yang telah dibuat
        for (int i = 0; i < jumlahBeli; i++) {
            System.out.printf("Masukkan kode barang ke-%d:\n", i + 1);
            listBelanja[i] = scan.nextInt();
            System.out.printf("Masukkan qty barang ke-%d:\n", i + 1);
            jmlBelanja[i] = scan.nextInt();

        }

        // looping untuk menampilkan nama, qty, harga, diskon, subtotal, dan total bayar
        for (int i = 0; i < listBelanja.length; i++) {
            System.out.println("Nama barang ke- " + (i + 1) + ":" + barangs[listBelanja[i]][0]);
            System.out.println("Qty" + ":" + jmlBelanja[i]);
            System.out.println("Harga" + ": Rp" + barangs[listBelanja[i]][1]);
            System.out.println("Diskon" + ": " + barangs[listBelanja[i]][2]);

            HitungDiskon subTotal = new HitungDiskon();
            subTotal.harga = (float) barangs[listBelanja[i]][1];
            subTotal.diskon = (float) barangs[listBelanja[i]][2];
            subTotal.qty = (float) jmlBelanja[i];
            subTotalBayar = subTotal.hitungDiskon(subTotal.harga, subTotal.qty, subTotal.diskon);
            System.out
                    .println("Sub total" + ": Rp"
                            + subTotalBayar);
            System.out.println("-----------------------------------");
            totalHarga += subTotalBayar;
            if (i == listBelanja.length - 1)
                System.out.println("Total belanja anda: Rp" + totalHarga);
        }
        // close scanner to avoid memory leak
        scan.close();

    }

}

class Barang extends Latihan_5 {
    static float subTotal;

}

// class hitungdiskon untuk menghitung subtotal
class HitungDiskon extends Barang {
    float harga, qty, diskon;

    float hitungDiskon(float a, float b, float c) {
        return subTotal = (float) (a * b) * (1 - c);
    }

}
