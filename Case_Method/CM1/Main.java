package Case_Method.CM1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilih;

        Mahasiswa mhs1 = new Mahasiswa("22001", "Andi", "Teknik Informatika");
        Mahasiswa mhs2 = new Mahasiswa("22002", "Budi", "Teknik Informatika");
        Mahasiswa mhs3 = new Mahasiswa("22003", "Citra", "Sistem Informasi Bisnis");

        Buku buku1 = new Buku("B001", "Algoritma", 2020);
        Buku buku2 = new Buku("B002", "Basis Data", 2019);
        Buku buku3 = new Buku("B003", "Pemrograman", 2021);
        Buku buku4 = new Buku("B004", "Fisika", 2024);

        Peminjaman pj1 = new Peminjaman(mhs1, buku1, 7, 2, 4000);
        Peminjaman pj2 = new Peminjaman(mhs2, buku2, 3, 0, 0);
        Peminjaman pj3 = new Peminjaman(mhs3, buku3, 10, 5, 10000);
        Peminjaman pj4 = new Peminjaman(mhs3, buku4, 6, 1, 2000);
        Peminjaman pj5 = new Peminjaman(mhs1, buku2, 4, 0, 0);

        Peminjaman[] arrPj = { pj1, pj2, pj3, pj4, pj5 };
        Mahasiswa[] arrMhs = { mhs1, mhs2, mhs3 };
        Buku[] arrBuku = { buku1, buku2, buku3, buku4 };

        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa ");
            System.out.println("2. Tampilkan Buku ");
            System.out.println("3. Tampilkan Peminjaman ");
            System.out.println("4. Urutkan Berdasarkan Denda ");
            System.out.println("5. Cari Berdasarkan NIM ");
            System.out.println("6. Tambah Data Peminjaman ");
            System.out.println("7. Tampilkan Statistik ");
            System.out.println("0. Keluar ");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    System.out.println("\nDaftar Mahasiswa: ");
                    mhs1.tampilMahasiswa();
                    mhs2.tampilMahasiswa();
                    mhs3.tampilMahasiswa();

                    break;

                case 2:
                    System.out.println("\nDaftar Buku: ");
                    buku1.tampilBuku();
                    buku2.tampilBuku();
                    buku3.tampilBuku();
                    buku4.tampilBuku();

                    break;

                case 3:
                    System.out.println("\nData Peminjaman: ");
                    for (int i = 0; i < arrPj.length; i++) {
                        arrPj[i].tampilPeminjaman();
                    }

                    break;

                case 4:
                    System.out.println("\nSetelah diurutkan (Denda terbesar): ");
                    for (int i = 0; i < arrPj.length - 1; i++) {
                        for (int j = 0; j < arrPj.length - i - 1; j++) {
                            if (arrPj[j].denda < arrPj[j + 1].denda) {
                                Peminjaman temp = arrPj[j];
                                arrPj[j] = arrPj[j + 1];
                                arrPj[j + 1] = temp;

                            }
                        }
                    }
                    for (int i = 0; i < arrPj.length; i++) {
                        arrPj[i].tampilPeminjaman();
                    }

                    break;

                case 5:
                    System.out.print("Masukkan NIM: ");
                    String nim = sc.next();
                    boolean cari = false;
                    for (int i = 0; i < arrPj.length; i++) {
                        if (arrPj[i].mhs.nim.equals(nim)) {
                            arrPj[i].tampilPeminjaman();
                            cari = true;
                        }
                    }
                    if (!cari) {
                        System.out.println("NIM tidak ditemukan.");
                    }
                    break;

                case 6:
                    sc.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim2 = sc.nextLine();
                    System.out.print("Masukkkan kode buku: ");
                    String kodeBuku = sc.nextLine();
                    System.out.print("Masukkan lama pinjam(HARI): ");
                    int lamaPinjam = sc.nextInt();

                    Mahasiswa mhsBaru = null;
                    for (int i = 0; i < arrMhs.length; i++) {
                        if (arrMhs[i].nim.equals(nim2)) {
                            mhsBaru = arrMhs[i];
                            break;
                        }
                    }
                    if (mhsBaru == null) {
                        System.out.println("NIM tidak ditemukan!");
                        break;
                    }

                    Buku bukuBaru = null;
                    for (int i = 0; i < arrBuku.length; i++) {
                        if (arrBuku[i].kodeBuku.equals(kodeBuku)) {
                            bukuBaru = arrBuku[i];
                            break;
                        }
                    }

                    if (bukuBaru == null) {
                        System.out.println("Buku tidak ditemukan!");
                        break;
                    }

                    int terlambat = 0;
                    int denda = 0;
                    if (lamaPinjam > 5) {
                        terlambat = lamaPinjam - 5;
                        denda = terlambat * 2000;
                    }

                    Peminjaman pjBaru = new Peminjaman(mhsBaru, bukuBaru, lamaPinjam, terlambat, denda);

                    Peminjaman[] newArr = new Peminjaman[arrPj.length + 1];
                    for (int i = 0; i < arrPj.length; i++) {
                        newArr[i] = arrPj[i];
                    }

                    newArr[arrPj.length] = pjBaru;
                    arrPj = newArr;

                    System.out.println("Data peminjaman berhasil ditambahkan");
                    break;

                case 7:
                    int totalDenda = 0;
                    int jumlahTerlambat = 0;
                    int tepatWaktu = 0;

                    for (int i = 0; i < arrPj.length; i++) {
                        totalDenda += arrPj[i].denda;

                        if (arrPj[i].terlambat > 0) {
                            jumlahTerlambat++;
                        } else {
                            tepatWaktu++;
                        }
                    }

                    System.out.println("=== STATISTIK PEMINJAMAN ===");
                    System.out.println("Total denda        : " + totalDenda);
                    System.out.println("Jumlah terlambat   : " + jumlahTerlambat);
                    System.out.println("Jumlah Tepat Waktu : " + tepatWaktu);
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem peminjaman ruang baca JTI");
                    break;

                default:
                    System.out.println("Menu tidak valid");
            }
        } while (pilih != 0);

        sc.close();

    }
}
