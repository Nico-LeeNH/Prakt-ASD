package Case_Method.CM2;

public class DaftarPesanan {
    Pesanan head;
    Pesanan tail;

    DaftarPesanan() {
        head = null;
        tail = null;
    }

    // Kompleksitas: O(1) — menyisipkan di tail yang sudah diketahui langsung,
    // tidak ada loop atau traversal, hanya update pointer.
    void tambahPesanan(int kode, String nama, int harga, String namaPembeli) {
        Pesanan baru = new Pesanan(kode, nama, harga, namaPembeli);

        if (head == null) {
            head = baru;
            tail = baru;
        } else {
            baru.prev = tail;
            tail.next = baru;
            tail = baru;
        }
    }

    // Kompleksitas: O(n²) — Bubble Sort dengan dua loop bersarang.
    // Kasus terbaik O(n) jika data sudah terurut (flag tukar=false langsung),
    // kasus terburuk O(n²) jika data terbalik urutannya.
    void sortingNama() {
        if (head == null)
            return;

        boolean tukar;
        do {
            tukar = false;
            Pesanan sekarang = head;
            while (sekarang.next != null) {
                if (sekarang.namaPesanan.compareToIgnoreCase(sekarang.next.namaPesanan) > 0) {
                    int tmpKode = sekarang.kodePesanan;
                    String tmpNama = sekarang.namaPesanan;
                    int tmpHarga = sekarang.harga;
                    String tmpPembeli = sekarang.namaPembeli;

                    sekarang.kodePesanan = sekarang.next.kodePesanan;
                    sekarang.namaPesanan = sekarang.next.namaPesanan;
                    sekarang.harga = sekarang.next.harga;
                    sekarang.namaPembeli = sekarang.next.namaPembeli;

                    sekarang.next.kodePesanan = tmpKode;
                    sekarang.next.namaPesanan = tmpNama;
                    sekarang.next.harga = tmpHarga;
                    sekarang.next.namaPembeli = tmpPembeli;

                    tukar = true;
                }
                sekarang = sekarang.next;
            }
        } while (tukar);
    }

    void tampil() {
        if (head == null) {
            System.out.println("Belum ada pesanan.");
            return;
        }

        sortingNama();
        System.out.println("=====================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("=====================================");
        System.out.printf("%-14s %-20s %-10s%n", "Kode Pesanan", "Nama Pesanan", "Harga");

        int total = 0;
        Pesanan sekarang = head;
        while (sekarang != null) {
            System.out.printf("%-14d %-20s %-10d%n",
                    sekarang.kodePesanan, sekarang.namaPesanan, sekarang.harga);
            total += sekarang.harga;
            sekarang = sekarang.next;

        }
    }

    public void totalPendapatan() {
        int total = 0;
        Pesanan sekarang = head;
        while (sekarang != null) {
            total += sekarang.harga;
            sekarang = sekarang.next;
        }
        System.out.println("TOTAL PENDAPATAN");
        System.out.println("==============================");
        System.out.println("Total Harga Seluruh Pesanan : Rp " + total);
    }

    // Kompleksitas: O(n) — harus traversal dari head untuk mencari kode pesanan.
    // Kasus terbaik O(1) jika kode ada di head, terburuk O(n) jika di tail atau tidak ada.
    void hapusPesanan(int kodePesanan) {
        if (head == null) {
            System.out.println("Belum ada pesanan.");
            return;
        }

        Pesanan sekarang = head;
        while (sekarang != null) {
            if (sekarang.kodePesanan == kodePesanan) {

                if (sekarang == head && sekarang == tail) {
                    head = null;
                    tail = null;
                }

                else if (sekarang == head) {
                    head = head.next;
                    head.prev = null;
                }

                else if (sekarang == tail) {
                    tail = tail.prev;
                    tail.next = null;

                }

                else {
                    sekarang.prev.next = sekarang.next;
                    sekarang.next.prev = sekarang.prev;
                }

                System.out.println("Pesanan kode " + kodePesanan + " berhasil dihapus.");
                return;
            }
            sekarang = sekarang.next;
        }

        System.out.println("Kode pesanan tidak ditemukan.");
    }

}
