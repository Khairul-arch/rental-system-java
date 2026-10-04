public class Car extends Vehicle {

    public Car(String nk, String merk, double harga) {
        super(nk, merk, harga);
    }

    @Override
    public String getType() {
        return "Car";
    }

    public double hargaTotal(int durasi) {
        cekHari(durasi);
        return getHarga() * durasi;
    }

    @Override
    public void printStatus() {
        System.out.println("Rental Mobil");
        super.printStatus();
    }

    @Override
    public double hitungHarga(int rentalDays) {
        return hargaTotal(rentalDays);
    }
}