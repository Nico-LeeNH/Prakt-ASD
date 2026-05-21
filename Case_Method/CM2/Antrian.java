package Case_Method.CM2;

public class Antrian {
    Pembeli head;
    Pembeli tail;
    int jumlah;
    int nomorurut;

    Antrian() {
        head = null;
        tail = null;
        jumlah = 0;
        nomorurut = 0;
    }

    void tambahAntrian(String nama, String noHp) {
        nomorurut++;
        Pembeli baru = new Pembeli(nomorurut, nama, noHp);

        if (head == null) {
            head = baru;
            tail = baru;
        } else {
            baru.prev = tail;
            tail.next = baru;
            tail = baru;
        }
        jumlah++;
        System.out.println("Antrian berhasil ditambahkan dengan nomor: " + nomorurut);
    }

    void cetakAntrian() {
        if (head == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("=============================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("=============================");
        System.out.printf("%-12s %-15s %-15s%n", "No Antrian", "Nama", "No Hp");

        Pembeli sekarang = head;
        while (sekarang != null) {
            System.out.printf("%-12d %-15s %-15s%n", sekarang.noAntrian, sekarang.namaPembeli, sekarang.noHp);
            sekarang = sekarang.next;
        }
    }

    String hapusAntrian(int noAntrian) {
        if (head == null) {
            System.out.println("Antrian kosong.");
            return null;
        }

        Pembeli sekarang = head;
        while (sekarang != null) {
            if (sekarang.noAntrian == noAntrian) {
                String nama = sekarang.namaPembeli;

                if (sekarang.prev != null) {
                    sekarang.prev.next = sekarang.next;
                } else {
                    head = sekarang.next;
                }

                if (sekarang.next != null) {
                    sekarang.next.prev = sekarang.prev;
                } else {
                    tail = sekarang.prev;
                }

                jumlah--;
                return nama;
            }
            sekarang = sekarang.next;
        }
        System.out.println("Nomor antrian tidak ditemukan.");
        return null;
    }
}
