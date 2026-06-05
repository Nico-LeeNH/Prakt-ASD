package Pertemuan14;

public class BinaryTreeArrayMain20 {
    public static void main(String[] args) {
        BinaryTreeArray20 bta = new BinaryTreeArray20();

        Mahasiswa20 mhs1 = new Mahasiswa20("244160121", "Ali", "A", 3.57);
        Mahasiswa20 mhs2 = new Mahasiswa20("244160185", "Candra", "C", 3.41);
        Mahasiswa20 mhs3 = new Mahasiswa20("244160221", "Badar", "B", 3.75);
        Mahasiswa20 mhs4 = new Mahasiswa20("244160220", "Dewi", "B", 3.35);
        Mahasiswa20 mhs5 = new Mahasiswa20("244160131", "Devi", "A", 3.48);
        Mahasiswa20 mhs6 = new Mahasiswa20("244160205", "Ehsan", "D", 3.61);
        Mahasiswa20 mhs7 = new Mahasiswa20("244160170", "Fizi", "B", 3.86);

        Mahasiswa20[] dataMahasiswa = { mhs1, mhs2, mhs3, mhs4, mhs5, mhs6, mhs7, null, null, null };
        int idxLast = 6;

        bta.populateData(dataMahasiswa, idxLast);

        System.out.println("\nInorder Traversal Mahasiswa: ");
        bta.traverseInOrder(0);
    }
}
