package Pertemuan12.Tugas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        int pilih;

        do {
            System.out.println("\n=== ANTRIAN LAYANAN KEMAHASISWAAN ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Panggil Antrian");
            System.out.println("3. Lihat Antrian Terdepan");
            System.out.println("4. Lihat Antrian Paling Belakang");
            System.out.println("5. Tampilkan Semua Antrian");
            System.out.println("6. Cek Antrian Kosong");
            System.out.println("7. Cek Antrian Penuh");
            System.out.println("8. Kosongkan Antrian");
            System.out.println("9. Jumlah Mahasiswa Mengantre");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();

                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();

                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();

                    Mahasiswa mhs = new Mahasiswa(nim, nama, prodi);
                    list.enqueue(mhs);

                    break;
                case 2:
                    Mahasiswa keluar = list.dequeue();

                    if (keluar != null) {
                        System.out.println("Mahasiswa dipanggil:");
                        keluar.tampilData();
                    }
                    break;
                case 3:
                    list.peekFront();
                    break;

                case 4:
                    list.peekRear();
                    break;

                case 5:
                    list.print();
                    break;
                case 6:
                    if (list.isEmpty()) {
                        System.out.println("Antrian kosong.");
                    } else {
                        System.out.println("Antrian tidak kosong.");
                    }
                    break;
                case 7:
                    if (list.isFull()) {
                        System.out.println("Antrian penuh.");
                    } else {
                        System.out.println("Antrian belum penuh.");
                    }
                    break;
                case 8:
                    list.clear();
                    break;

                case 9:
                    list.jumlahAntrian();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak valid.");

            }
        } while (pilih != 0);

        sc.close();
    }
}
