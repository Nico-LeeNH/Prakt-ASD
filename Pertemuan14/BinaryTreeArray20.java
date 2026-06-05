package Pertemuan14;

public class BinaryTreeArray20 {
    Mahasiswa20[] dataMahasiswa;
    int idxLast;

    public BinaryTreeArray20() {
        this.dataMahasiswa = new Mahasiswa20[20];
    }

    void populateData(Mahasiswa20 dataMhs[], int idxLast) {
        this.dataMahasiswa = dataMhs;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1);
                dataMahasiswa[idxStart].tampilInformasi();
                traverseInOrder(2 * idxStart + 2);
            }
        }
    }

    public void add(Mahasiswa20 data) {
        for (int i = 0; i < dataMahasiswa.length; i++) {
            if (dataMahasiswa[i] == null) {
                dataMahasiswa[i] = data;
                if (i > idxLast) {
                    idxLast = i;
                }
                System.out.println("Data " + data.nama + " berhasil masuk ke array index " + i);
                return;
            }
        }
        System.out.println("Array penuh, gagal menambah " + data.nama);
    }

    public void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                dataMahasiswa[idxStart].tampilInformasi();
                traversePreOrder(2 * idxStart + 1);
                traversePreOrder(2 * idxStart + 2);
            }
        }
    }
}
