public class Motor extends Vehicle {

    private int hariDiskon = 3;
    private double diskon = 0.10;

    public Motor(String nk, String merk, double harga) {
        super(nk, merk, harga);
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }

    public double hargaTotal(int durasi) {
        cekHari(durasi);

        double total = getHarga() * durasi;

        if (durasi >= hariDiskon) {
            total -= total * diskon;
        }

        return total;
    }

    @Override
    public void printStatus() {
        System.out.println("Rental Motor");
        super.printStatus();
    }

    @Override
    public double hitungHarga(int rentalDays) {
        return hargaTotal(rentalDays);
    }
}
