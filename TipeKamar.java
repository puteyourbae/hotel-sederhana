package modul_2;

public enum TipeKamar {
    STANDARD("Standard", 500000), // Konstanta
    DELUXE("Deluxe", 800000),     // Konstanta
    SUITE("Suite", 1500000);      // Konstanta

    private final String namaTipe;
    private final double hargaDasar;

    // Konstruktor Enum
    TipeKamar(String namaTipe, double hargaDasar) {
        this.namaTipe = namaTipe;
        this.hargaDasar = hargaDasar;
    }

    // Getters
    public String getNamaTipe() {
        return namaTipe;
    }

    public double getHargaDasar() {
        return hargaDasar;
    }
}