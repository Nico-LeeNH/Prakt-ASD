package Tugas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS antrian = new AntrianKRS(10);
        int pilih;

        do {
            System.out.println("\n=== ANTRIAN KRS ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Proses KRS (2 orang)");
            System.out.println("3. Lihat Semua");
            System.out.println("4. Lihat 2 Terdepan");
            System.out.println("5. Lihat Terakhir");
            System.out.println("6. Jumlah Antrian");
            System.out.println("7. Jumlah Dilayani");
            System.out.println("8. Sisa Belum KRS");
            System.out.println("9. Clear");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi: ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = sc.nextLine();

                    antrian.enqueue(new Mahasiswa(nim, nama, prodi, kelas));
                    break;

                case 2:
                    antrian.dequeue();
                    break;

                case 3:
                    antrian.printAll();
                    break;

                case 4:
                    antrian.lihatDepan();
                    break;

                case 5:
                    antrian.lihatBelakang();
                    break;

                case 6:
                    antrian.jumlahAntrian();
                    break;

                case 7:
                    antrian.jumlahDilayani();
                    break;

                case 8:
                    antrian.jumlahBelum();
                    break;

                case 9:
                    antrian.clear();
                    break;
            }

        } while (pilih != 0);

        sc.close();
    }
}
