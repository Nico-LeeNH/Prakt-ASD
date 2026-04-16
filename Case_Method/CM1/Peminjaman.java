package Case_Method.CM1;

public class Peminjaman {
    Mahasiswa mhs;
    Buku buku;
    int lamaPinjam;
    int batasPinjam = 5;
    int terlambat;
    int denda;

    Peminjaman(Mahasiswa mhs, Buku buku, int lamaPinjam, int terlambat, int denda) {
        this.mhs = mhs;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
        this.terlambat = terlambat;
        this.denda = denda;
    }

    void tampilPeminjaman() {
        System.out.println(mhs.nama + " | " + buku.judul + " | " + "Lama: " + lamaPinjam + " | " + "Terlambat: "
                + terlambat + " | " + "Denda: " + denda);

    }
}
