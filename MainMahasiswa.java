public class MainMahasiswa {
    public static void main(String[] args) {
        Mahasiswa[] data = {
                new Mahasiswa("Ahmad", "220101001", 2022, 78, 82),
                new Mahasiswa("Budi", "220101002", 2022, 85, 88),
                new Mahasiswa("Cindy", "220101003", 2021, 90, 87),
                new Mahasiswa("Dian", "220101004", 2021, 76, 79),
                new Mahasiswa("Eko", "220101005", 2023, 92, 95),
                new Mahasiswa("Fajar", "220101006", 2020, 88, 85),
                new Mahasiswa("Gina", "220101007", 2023, 80, 83),
                new Mahasiswa("Hadi", "220101008", 2020, 82, 84)
        };

        NilaiMahasiswa mhs = new NilaiMahasiswa();
        int maxUTS = mhs.maxUTS(data, 0, data.length - 1);
        int minUTS = mhs.minUTS(data, 0, data.length - 1);
        double rataUAS = mhs.rataUAS(data);

        System.out.println("Nilai UTS Tertinggi : " + maxUTS);
        System.out.println("Nilai UTS Terendah : " + minUTS);
        System.out.println("Rata-rata Nilai UAS : " + rataUAS);
    }
}
