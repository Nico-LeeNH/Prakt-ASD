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

    // Kompleksitas: O(1) — selalu menyisipkan di tail yang sudah diketahui,
    // tidak perlu traversal sama sekali. Jumlah node tidak mempengaruhi waktu.
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

    // Kompleksitas: O(1) — hapus selalu dari head yang sudah diketahui,
    // hanya update 2-3 pointer.
    String remove() {
        // Antrian kosong
        if (head == null) {
            System.out.println("Antrian kosong, tidak ada yang bisa dihapus.");
            return null;
        }

        String namaTerhapus = head.namaPembeli;

        // Hanya ada 1 node (head == tail)
        if (head == tail) {
            head = null;
            tail = null;
        }
        // Lebih dari 1 node
        else {
            head = head.next;
            head.prev = null;
        }

        jumlah--;
        return namaTerhapus;
    }

    // Kompleksitas: O(n) — dalam kasus terburuk (nama tidak ada atau ada di tail),
    // seluruh n node ditelusuri satu per satu dari head ke tail.
    void cariPembeli(String nama) {
        if (head == null) {
            System.out.println("Antrian kosong.");
            return;
        }

        Pembeli sekarang = head;
        while (sekarang != null) {

            if (sekarang.namaPembeli.equalsIgnoreCase(nama)) {
                System.out.println("==============================");
                System.out.println("Pembeli ditemukan!");
                System.out.println("==============================");
                System.out.printf("No Antrian : %d%n", sekarang.noAntrian);
                System.out.printf("Nama       : %s%n", sekarang.namaPembeli);
                System.out.printf("No HP      : %s%n", sekarang.noHp);
                return;
            }
            sekarang = sekarang.next;
        }

        System.out.println("Pembeli tidak ditemukan.");
    }

    
    // Kompleksitas: O(n²) — ada dua loop bersarang: loop luar berjalan sebanyak n kali,
    // loop dalam berjalan n-1, n-2, ... 1 kali. Total perbandingan = n*(n-1)/2.
    void sortAntrian() {
        if (head == null || head == tail) {
            System.out.println("Antrian tidak perlu diurutkan (kurang dari 2 pembeli).");
            return;
        }

        Pembeli i = head;
        while (i != null) {

            Pembeli minNode = i;

            Pembeli j = i.next;
            while (j != null) {

                if (j.namaPembeli.compareToIgnoreCase(minNode.namaPembeli) > 0) {
                    minNode = j;
                }
                j = j.next;
            }

            if (minNode != i) {
                int tmpNo = i.noAntrian;
                i.noAntrian = minNode.noAntrian;
                minNode.noAntrian = tmpNo;

                String tmpNama = i.namaPembeli;
                i.namaPembeli = minNode.namaPembeli;
                minNode.namaPembeli = tmpNama;

                String tmpHp = i.noHp;
                i.noHp = minNode.noHp;
                minNode.noHp = tmpHp;
            }

            i = i.next;
        }

        System.out.println("Antrian berhasil diurutkan berdasarkan nama (A-Z).");
        cetakAntrian();
    }

}
