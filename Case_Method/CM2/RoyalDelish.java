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
            System.out.println("5. Total Pendapatan");
            System.out.println("6. Hapus Pesanan");
            System.out.println("7. Cari Pembeli");
            System.out.println("8. Urutkan Antrian");
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
                case 5:
                    dfpesanan.totalPendapatan();
                    break;
                case 6:
                    dfpesanan.tampil();
                    if (dfpesanan.head == null)
                        return;

                    System.out.print("Masukkan Kode Pesanan yang ingin dihapus: ");
                    int kode = sc.nextInt();
                    sc.nextLine();
                    dfpesanan.hapusPesanan(kode);
                    break;
                case 7:
                    System.out.print("Masukkan Nama Pembeli yang dicari: ");
                    nama = sc.nextLine();
                    antrian.cariPembeli(nama);
                    break;
                case 8:
                    antrian.sortAntrian();
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

        String namaPembeli = antrian.remove();
        if (namaPembeli == null)
            return;

        System.out.println("Memanggil : " + namaPembeli);

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
