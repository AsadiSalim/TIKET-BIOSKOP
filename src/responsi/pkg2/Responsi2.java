/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.pkg2;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author AGUSTINA
 */
public class Responsi2 {

    /**
     * @param args the command line arguments
     */
    // TODO code application logic here
    public static void main(String[] args) {
        menu_awal();
    }

    //global variable
    static Scanner sc = new Scanner(System.in);
    static String[] judul = {"Deadpool 2", "Dilan 1990", "Ananta", "INSIDIOUS", "AVENGERS : INFINITY WAR",
        "THE DEATH CURE", "SURAT CINTA UNTUK STARLA", "EVERYDAY",
        "TRUTH OR DARE", "THE SECRET - SUSTER NGESOT URBAN LEGEND"};
    static String[] jadwal = {"10.00 - 12.30", "12.45 - 14.55", "15.00 - 17.30", "17.30 - 19.45", "20.00 - 22.30"};
    static int harga = 35000;
    static char ulang;

    public static void menu_awal() {
        int pilih_menu;
        do {
            System.out.println("========== Bioskop XXI ==========");
            System.out.println("1.\tJudul Film");
            System.out.println("2.\tJadwal");
            System.out.println("3.\tTransaksi");
            System.out.println("=================================");
            System.out.print("Pilih : ");

            pilih_menu = sc.nextInt();

            System.out.println("");
            switch (pilih_menu) {
                case 1:
                    judul_film();
                    break;
                case 2:
                    jadwal_film();
                    break;
                case 3:
                    transaksi();
                    break;

                default:
                    System.out.println("Inputan salah!");
            }
        } while (ulang == 'Y' || ulang == 'y');
    }

    public static void judul_film() {
        System.out.println("Theater | Judul Film");
        for (int x = 0; x < judul.length; x++) {
            System.out.println((x + 1) + "\t| " + judul[x]);
        }
        System.out.print("ingin kembali ke menu awal ?(Y/T) ");
        ulang = sc.next().charAt(0);
    }

    public static void jadwal_film() {
        System.out.println("No. | Jadwal");
        for (int x = 0; x < jadwal.length; x++) {
            System.out.println((x + 1) + "   | " + jadwal[x]);
        }
        System.out.print("ingin kembali ke menu awal ?(Y/T) ");
        ulang = sc.next().charAt(0);
    }

    public static void transaksi() {
        System.out.println("========== Transaksi ==========");
        System.out.println("No, | Judul Film");
        for (int x = 0; x < judul.length; x++) {
            System.out.println((x + 1) + "   | " + judul[x]);
        }
        System.out.println("===============================");
        System.out.print("Pilih : ");
        int pilih_judul = sc.nextInt();

        System.out.println("");
        System.out.println("No. | Jadwal");
        for (int x = 0; x < jadwal.length; x++) {
            System.out.println((x + 1) + "   | " + jadwal[x]);
        }
        System.out.print("Pilih : ");
        int pilih_jadwal = sc.nextInt();
        int kapasitas = 0;
        System.out.println("Pilih Studio (1-3) : ");
        int studio = sc.nextInt();
        switch (studio) {
            case 1:
                kapasitas = 30;
                break;
            case 2:
                kapasitas = 35;
                break;
            case 3:
                kapasitas = 40;
                break;
        }
        System.out.println("");
        int kursi;

        do {
            System.out.println("Jumlah Kursi : ");
            System.out.println("");
            kursi = sc.nextInt();
            if (kursi > kapasitas) {
                System.out.println("jumlah kursi yang dipesen melebihi kapasitas yang tersedia."
                        + "Ulangi memasukkan jumlah kursi.");
            }
        } while (kursi > kapasitas);

        int total = kursi * harga;
        System.out.println("===============================");
        System.out.println(" Judul Film\t: " + judul[(pilih_judul - 1)]);
        System.out.println(" Studio\t\t: " + pilih_judul);
        System.out.println(" Jadwal Film\t: " + jadwal[(pilih_jadwal - 1)]);
        System.out.println(" Kursi\t\t: " + kursi);
        System.out.println(" Total Bayar\t: " + total);
        System.out.println("===============================");
        System.out.print(" Bayar\t: ");
        int bayar = sc.nextInt();
        if (bayar < total) {
            System.out.println("Maaf, Uang anda kurang");
        } else {
            int kembalian = bayar - total;
            System.out.println(" Kembalian\t: " + kembalian);
        }
        System.out.println("");

    }
}
