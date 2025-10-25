package modul_2;

/**
 * Kelas Kamar.
 * Merepresentasikan satu kamar di hotel dengan status ketersediaan dan tipe kamar.
 * Menerapkan prinsip encapsulation (atribut private) dan menggunakan enum TipeKamar.
 *
 * @author putri
 * @version 1.1
 * @since 2025-10-25
 */

public class Kamar {
    private final int nomorKamar; // Dibuat final karena nomor kamar tidak boleh berubah
    private final TipeKamar tipe;
    private boolean isTersedia;

    /**
     * Konstruktor untuk kelas Kamar.
     * Secara default, kamar yang baru dibuat berstatus tersedia (isTersedia = true).
     *
     * @param nomorKamar Nomor unik untuk kamar tersebut.
     * @param tipe Tipe kamar (diambil dari enum TipeKamar).
     */
    public Kamar(int nomorKamar, TipeKamar tipe) {
        this.nomorKamar = nomorKamar;
        this.tipe = tipe;
        this.isTersedia = true;
    }

    // Getters
    public int getNomorKamar() {
        return nomorKamar;
    }

    public TipeKamar getTipe() {
        return tipe;
    }

    // Harga sekarang diambil dari Enum
    public double getHargaPerMalam() {
        return tipe.getHargaDasar();
    }
    /**
     * Mengubah status ketersediaan kamar.
     *
     * @param tersedia Status baru ketersediaan (true jika tersedia, false jika dipesan).
     */
    public boolean isTersedia() {
        return isTersedia;
    }

    // Setter
    public void setTersedia(boolean tersedia) {
        this.isTersedia = tersedia;
    }
    /**
     * Menampilkan informasi rinci dan status ketersediaan kamar.
     *
     * @return String yang berisi detail kamar, harga, dan status.
     */
    public String cekKetersediaan() {
        String status = this.isTersedia ? "Tersedia" : "Dipesan";
        return String.format("Kamar %d (%s) - Rp %,.0f/malam. Status: %s",
                nomorKamar, tipe.getNamaTipe(), getHargaPerMalam(), status);
    }
}
