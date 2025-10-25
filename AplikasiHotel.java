package modul_2;

public class AplikasiHotel {
    public static void main(String[] args) {
        HotelManager manager = new HotelManager();

        // 1. Inisialisasi Kamar menggunakan ENUM
        manager.tambahKamar(new Kamar(101, TipeKamar.STANDARD));
        manager.tambahKamar(new Kamar(102, TipeKamar.STANDARD));
        manager.tambahKamar(new Kamar(201, TipeKamar.DELUXE));
        manager.tambahKamar(new Kamar(202, TipeKamar.DELUXE));
        manager.tambahKamar(new Kamar(301, TipeKamar.SUITE));

        // 2. Tampilkan Kamar Tersedia (Standard)
        System.out.println("\n--- KAMAR STANDARD TERSEDIA ---");
        // Pemanggilan method sekarang menggunakan TipeKamar.STANDARD
        manager.cariKamarTersedia(TipeKamar.STANDARD).forEach(k -> System.out.println(k.cekKetersediaan()));

        // 3. Proses Pemesanan 1
        System.out.println("\n--- PROSES PEMESANAN STANDARD ---");
        manager.buatPemesanan(101, "Putry Adillah", 3);

        // 4. Proses Pemesanan 2 (Deluxe)
        System.out.println("\n--- PROSES PEMESANAN DELUXE ---");
        Pemesanan p2 = manager.buatPemesanan(202, "Putry Adillah", 5);

        // 5. Cek Kamar Suite
        System.out.println("\n--- KAMAR SUITE TERSEDIA ---");
        manager.cariKamarTersedia(TipeKamar.SUITE).forEach(k -> System.out.println(k.cekKetersediaan()));

        // 6. Cetak Nota
        if (p2 != null) {
            manager.cetakNota(p2.getId());
        }
    }
}