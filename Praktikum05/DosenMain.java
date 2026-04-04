package Praktikum05;

import java.util.Scanner;

public class DosenMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataDosen data = new DataDosen();

        int pilih;

        do {
            System.out.println("\n-------- Menu --------");
            System.out.println("1. Tambah Data Dosen");
            System.out.println("2. Tampil Data");
            System.out.println("3. Sorting ASC (Usia termuda -> tertua)");
            System.out.println("4. Sorting DSC (Usia tertua -> termuda)");
            System.out.println("5. Insertion Sort (Usia tertua -> termuda)");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilih = Integer.parseInt(sc.nextLine());

            switch (pilih) {
                case 1:
                    System.out.print("Kode        :");
                    String kd = sc.nextLine();
                    System.out.print("Nama        :");
                    String nama = sc.nextLine();

                    boolean jk;
                    while (true) {
                        System.out.print("Jenis Kelamin (L/P): ");
                        String input = sc.nextLine();
                        if (input.equalsIgnoreCase("L")) {
                            jk = true;
                            break;
                        } else if (input.equalsIgnoreCase("P")) {
                            jk = false;
                            break;
                        } else {
                            System.out.println("input salah");
                        }
                    }

                    System.out.print("Usia     : ");
                    int usia = Integer.parseInt(sc.nextLine());

                    data.tambah(new Dosen(kd, nama, jk, usia));
                    break;

                case 2:
                    data.tampil();
                    break;

                case 3:
                    System.out.println("Data diurutkan menggunakan Sorting (ASC)");
                    data.SortingASC();
                    data.tampil();
                    break;

                case 4:
                    System.out.println("Data diurutkan menggunakan Sorting (DSC)");
                    data.SortingDSC();
                    data.tampil();
                    break;

                case 5:
                     System.out.println("Data diurutkan menggunakan Insertion Sort");
                    data.insertionSort();
                    data.tampil();
                    break;

                case 6:
                    System.out.println("Keluar dari program");
                    break;

                default:
                    System.out.println("Menu tidak valid");
            }
        } while (pilih != 6);

        sc.close();

    }
}
