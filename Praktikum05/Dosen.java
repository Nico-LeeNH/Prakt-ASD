package Praktikum05;

public class Dosen {
    String kode;
    String nama;
    Boolean jenisKelamin;
    int umur;

    Dosen(String kd, String name, Boolean jk, int age) {
        kode = kd;
        nama = name;
        jenisKelamin = jk;
        umur = age;
    }

    void tampil() {
        System.out.println("Kode               : " + kode);
        System.out.println("Nama               : " + nama);
        System.out.println("Jenis Kelamin      : " + (jenisKelamin ? "Laki-laki" : "Perempuan"));
        System.out.println("Usia               : " + umur);
        System.out.println("--------------------------------");
    }
}
