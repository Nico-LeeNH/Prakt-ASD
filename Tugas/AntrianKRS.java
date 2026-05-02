package Tugas;

public class AntrianKRS {
    Mahasiswa[] data;
    int front, rear, size, max;
    int sudahDilayani;

    public AntrianKRS(int max) {
        this.max = max;
        data = new Mahasiswa[max];
        front = 0;
        rear = -1;
        size = 0;
        sudahDilayani = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == max;
    }

    void enqueue(Mahasiswa m) {
        if (isFull()) {
            System.out.println("Antrian penuh!");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = m;
        size++;
        System.out.println("Mahasiswa masuk antrian");
    }

    // Layani 2 mahasiswa
    void dequeue() {
        if (size < 2) {
            System.out.println("Antrian kurang dari 2!");
            return;
        }

        for (int i = 0; i < 2; i++) {
            Mahasiswa m = data[front];
            System.out.print("Dilayani: ");
            m.tampilData();

            front = (front + 1) % max;
            size--;
            sudahDilayani++;
        }
    }

    void lihatDepan() {
        if (size < 2) {
            System.out.println("Kurang dari 2 antrian");
            return;
        }

        System.out.println("2 Antrian terdepan:");
        data[front].tampilData();
        data[(front + 1) % max].tampilData();
    }

    void lihatBelakang() {
        if (isEmpty()) {
            System.out.println("Kosong");
        } else {
            System.out.println("Antrian terakhir:");
            data[rear].tampilData();
        }
    }

    void printAll() {
        if (isEmpty()) {
            System.out.println("Kosong");
            return;
        }

        for (int i = 0; i < size; i++) {
            int idx = (front + i) % max;
            data[idx].tampilData();
        }
    }

    void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian dikosongkan");
    }

    void jumlahAntrian() {
        System.out.println("Jumlah antrian: " + size);
    }

    void jumlahDilayani() {
        System.out.println("Sudah dilayani: " + sudahDilayani);
    }

    void jumlahBelum() {
        int belum = 30 - sudahDilayani;
        System.out.println("Belum KRS: " + belum);
    }
}
