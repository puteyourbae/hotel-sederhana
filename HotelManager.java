package modul_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HotelManager {
    // Definisi Konstanta Lain yang tidak termasuk dalam Enum TipeKamar
    private static final String NAMA_HOTEL = "Hotel Pintar";

    private List<Kamar> daftarKamar;
    private List<Pemesanan> daftarPemesanan;
    private int idCounter;

    public HotelManager() {
        this.daftarKamar = new ArrayList<>();
        this.daftarPemesanan = new ArrayList<>();
        this.idCounter = 1;
    }

    public void tambahKamar(Kamar kamar) {
        this.daftarKamar.add(kamar);
    }

    // Method: Mencari kamar sekarang menggunakan TipeKamar enum
    public List<Kamar> cariKamarTersedia(TipeKamar tipe) {
        List<Kamar> hasil = new ArrayList<>();
        // Menggunakan Stream API
        for (Kamar k : daftarKamar) {
            if (k.isTersedia() && k.getTipe() == tipe) { // Perbandingan menggunakan operator ==
                hasil.add(k);
            }
        }
        return hasil;
    }

    // Method: Membuat pemesanan baru (Tidak ada perubahan signifikan dari versi sebelumnya)
    public Pemesanan buatPemesanan(int nomorKamar, String namaPelanggan, int jumlahMalam) {
        // ... (Logika pencarian kamar tetap sama)
        Optional<Kamar> kamarOpt = daftarKamar.stream()
                .filter(k -> k.getNomorKamar() == nomorKamar)
                .findFirst();

        if (kamarOpt.isEmpty() || !kamarOpt.get().isTersedia()) {
            System.out.println("❌ Kamar " + nomorKamar + " tidak tersedia atau tidak ditemukan.");
            return null;
        }

        Kamar kamar = kamarOpt.get();
        kamar.setTersedia(false);
        Pemesanan pemesananBaru = new Pemesanan(idCounter++, kamar, namaPelanggan, jumlahMalam);
        daftarPemesanan.add(pemesananBaru);
        System.out.println("✅ Pemesanan berhasil! ID: " + pemesananBaru.getId());
        return pemesananBaru;
    }

    public void cetakNota(int id) {
        // ... (Logika pencarian pemesanan tetap sama)
        Optional<Pemesanan> pemesananOpt = daftarPemesanan.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (pemesananOpt.isEmpty()) {
            System.out.println("❌ Pemesanan dengan ID " + id + " tidak ditemukan.");
            return;
        }

        Pemesanan p = pemesananOpt.get();
        double total = p.hitungTotalBiaya();

        // Menggunakan Konstanta NAMA_HOTEL
        System.out.println("\n" + "=".repeat(40));
        System.out.println("       NOTA PEMBAYARAN " + NAMA_HOTEL.toUpperCase());
        System.out.println("=".repeat(40));
        System.out.printf("%-15s: %d\n", "ID Pemesanan", p.getId());
        System.out.printf("%-15s: %s\n", "Pelanggan", p.getNamaPelanggan());
        System.out.printf("%-15s: %d\n", "Nomor Kamar", p.getKamar().getNomorKamar());
        System.out.printf("%-15s: %s\n", "Tipe Kamar", p.getKamar().getTipe().getNamaTipe());
        System.out.printf("%-15s: %d malam\n", "Durasi", p.getJumlahMalam());
        System.out.printf("%-15s: Rp %,.0f\n", "Harga/Malam", p.getKamar().getHargaPerMalam());
        System.out.println("-".repeat(40));
        System.out.printf("%-15s: Rp %,.0f\n", "TOTAL", total);
        System.out.println("=".repeat(40));
    }
}