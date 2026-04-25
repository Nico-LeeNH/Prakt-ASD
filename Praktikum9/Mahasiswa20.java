package Praktikum9;

public class Mahasiswa20 {
    String nim;
    String nama;
    String kelas;
    int nilai;

    Mahasiswa20() {

    }

    Mahasiswa20(String nama, String nim, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
    }

    void tugasDinilai(int nilai) {
        this.nilai = nilai;
    }

}
