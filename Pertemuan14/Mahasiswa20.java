package Pertemuan14;

public class Mahasiswa20 {
    String nama;
    String nim;
    String kelas;
    Double ipk;

    public Mahasiswa20() {

    }

    public Mahasiswa20(String nama, String nim, String kelas, Double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    public void tampilInformasi() {
        System.out.println("NIM: " + this.nim + " " +
                "Nama: " + this.nama + " " +
                "Kelas: " + this.kelas + " " +
                "IPK: " + this.ipk);
    }
}
