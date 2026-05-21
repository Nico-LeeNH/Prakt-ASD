package Case_Method.CM2;

public class DaftarPesanan {
    Pesanan head;
    Pesanan tail;

    DaftarPesanan() {
        head = null;
        tail = null;
    }

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
}
