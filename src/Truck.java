public class Truck extends Vehicle {

    private double biayaTambahan = 200000;

    public Truck(String nk, String merk, double harga) {
        super(nk, merk, harga);
    }

    @Override 
    public String getType() {
        return "Truck";
    }

    @Override
    public double hitungHarga(int durasi) {

        cekHari(durasi);

        return (getHarga() * durasi) + biayaTambahan;
    }

    @Override
    public void printStatus() {
        System.out.println("Rental Truck");
        super.printStatus();
    }
}
