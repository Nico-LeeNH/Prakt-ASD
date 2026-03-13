public class NilaiMahasiswa {
    int maxUTS(Mahasiswa[] data, int l, int r) {
        if (l == r) {
            return data[l].nilaiUTS;
        }

        int mid = (l + r) / 2;

        int leftMax = maxUTS(data, l, mid);
        int rightMax = maxUTS(data, mid + 1, r);

        return Math.max(leftMax, rightMax);
    }

    int minUTS(Mahasiswa[] data, int l, int r) {
        if (l == r) {
            return data[l].nilaiUTS;
        }

        int mid = (l + r) / 2;

        int leftMin = minUTS(data, l, mid);
        int rightMin = minUTS(data, mid + 1, r);

        return Math.min(leftMin, rightMin);
    }

    double rataUAS(Mahasiswa[] data) {
        int total = 0;

        for (int i = 0; i < data.length; i++) {
            total += data[i].nilaiUAS;
        }

        return (double) total / data.length;
    }
}
