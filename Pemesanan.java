package modul_2;

public class Pemesanan {
    private int id;
    private Kamar kamar;
    private String namaPelanggan;
    private int jumlahMalam;

    // Konstruktor
    public Pemesanan(int id, Kamar kamar, String namaPelanggan, int jumlahMalam) {
        this.id = id;
        this.kamar = kamar;
        this.namaPelanggan = namaPelanggan;
        this.jumlahMalam = jumlahMalam;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public int getJumlahMalam() {
        return jumlahMalam;
    }

    /**
     * Method Perhitungan: Menghitung total biaya.
     */
    public double hitungTotalBiaya() {
        // Logika perhitungan yang ringkas dan terenkapsulasi
        return kamar.getHargaPerMalam() * jumlahMalam;
    }
}
