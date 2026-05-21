package Case_Method.CM2;

import java.util.Scanner;

public class RoyalDelish {
    static Antrian antrian = new Antrian();
    static DaftarPesanan dfpesanan = new DaftarPesanan();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("==============================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("==============================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();
                    System.out.print("No Hp        : ");
                    String noHp = sc.nextLine();
                    antrian.tambahAntrian(nama, noHp);
                    break;
                case 2:
                    antrian.cetakAntrian();
                    break;
                case 3:
                    menuHapusAntrian();
                    break;
                case 4:
                    dfpesanan.tampil();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Menu tidak valid");
            }
        } while (pilihan != 0);
    }

    static void menuHapusAntrian() {
        antrian.cetakAntrian();
        if (antrian.head == null)
            return;

        System.out.print("Masukkan No Antrian yang dipanggil: ");
        int noAntrian = sc.nextInt();
        sc.nextLine();

        String namaPembeli = antrian.hapusAntrian(noAntrian);
        if (namaPembeli == null)
            return;

        System.out.print("Kode Pesanan  : ");
        int kode = sc.nextInt();
        sc.nextLine();
        System.out.print("Nama Pesanan  : ");
        String namaPesanan = sc.nextLine();
        System.out.print("Harga         : ");
        int harga = sc.nextInt();
        sc.nextLine();

        dfpesanan.tambahPesanan(kode, namaPesanan, harga, namaPembeli);
        System.out.println(namaPembeli + " telah memesan " + namaPesanan);
    }
}
