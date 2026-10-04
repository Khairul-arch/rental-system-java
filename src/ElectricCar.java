public class ElectricCar extends Car {

    private double chargingFee = 150000;

    public ElectricCar(String nk, String merk, double harga) {
        super(nk, merk, harga);
    }

    @Override
    public String getType() {
        return "Electric Car";
    }

    @Override
    public double hitungHarga(int durasi) {

        cekHari(durasi);

        return (getHarga() * durasi) + chargingFee;
    }

    @Override
    public void printStatus() {
        System.out.println("Rental Electric Car");
        super.printStatus();
    }
}
