package Pertemuan12;

public class Mahasiswa20 {
    String nim;
    String nama;
    String kelas;
    Double ipk;

    Mahasiswa20() {
    }

    Mahasiswa20(String name, String nm, String kls, Double ip) {
        nim = nm;
        nama = name;
        kelas = kls;
        ipk = ip;
    }

    public void tampilInformasi() {
        System.out.printf("%-15s %-15s %-5s %.1f%n", nama, nim, kelas, ipk);
    }

}
