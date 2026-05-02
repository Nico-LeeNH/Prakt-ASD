package Tugas;

public class Mahasiswa {
    String nim, nama, prodi, kelas;

    Mahasiswa(String nim, String nama, String prodi, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.kelas = kelas;
    }

    void tampilData() {
        System.out.println(nim + " | " + nama + " | " + prodi + " | " + kelas);
    }
}
