package Praktikum9;

public class StackSurat {
    Surat20[] data;
    int top;

    public StackSurat(int size) {
        data = new Surat20[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public void push(Surat20 s) {
        if (isFull()) {
            System.out.println("Stack penuh!");
        } else {
            data[++top] = s;
        }
    }

    public Surat20 pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return null;
        } else {
            return data[top--];
        }
    }

    public void peek() {
        if (!isEmpty()) {
            System.out.println("Surat teratas:");
            data[top].tampil();
        } else {
            System.out.println("Tidak ada surat");
        }
    }

    public void cari(String nama) {
        boolean ketemu = false;
        for (int i = 0; i <= top; i++) {
            if (data[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                data[i].tampil();
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("Data tidak ditemukan");
        }
    }
}
