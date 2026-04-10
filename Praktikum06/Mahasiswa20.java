package Praktikum06;

public class Mahasiswa20 {
    String nim;
    String nama;
    String kelas;
    Double ipk;

    Mahasiswa20() {

    }

    Mahasiswa20(String nm, String name, String kls, Double ip) {
        nim = nm;
        nama = name;
        kelas = kls;
        ipk = ip;
    }

    void tampilInformasi() {
        System.out.println("NIM     : " + nim);
        System.out.println("Nama    : " + nama);
        System.out.println("Kelas   : " + kelas);
        System.out.println("Ipk     : " + ipk);
        System.out.println("-------------------------");
    }
}
