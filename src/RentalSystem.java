import java.util.ArrayList;
import java.util.List;

public class RentalSystem {

    private String nama;
    private List<Vehicle> vehicles;
    private int sudahSewa = 0;

    public RentalSystem(String nama) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama customer tidak boleh kosong.");
        }
        this.nama = nama;
        this.vehicles = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public void tambahKendaraan(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Kendaraan tidak boleh null.");
        }
        vehicles.add(vehicle);
    }

    public Vehicle cariKendaraan(String nk) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getNk().equals(nk)) {
                return vehicle;
            }
        }
        return null;
    }

    public void tampilkanKendaraanTersedia() {
        System.out.println("\n=== KENDARAAN TERSEDIA ===");
        boolean ada = false;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.isStatus()) {
                vehicle.printStatus();
                System.out.println("-------------------------");
                ada = true;
            }
        }

        if (!ada) {
            System.out.println("Tidak ada kendaraan yang tersedia.");
        }
    }

    public double sewaKendaraan(String nk, int hari) 
            throws VehicleNotFoundException, VehicleNotAvailableException, 
                   InvalidRentalDurationException, RentalLimitExceededException {

        if (sudahSewa >= 3) {
            throw new RentalLimitExceededException("Rental limit exceeded. Maksimal menyewa 3 kendaraan.");
        }

        Vehicle vehicle = cariKendaraan(nk);
        if (vehicle == null) {
            throw new VehicleNotFoundException("Vehicle " + nk + " was not found.");
        }

        if (!vehicle.isStatus()) {
            throw new VehicleNotAvailableException("Vehicle " + nk + " is not available.");
        }

        if (hari <= 0) {
            throw new InvalidRentalDurationException("Rental duration must be greater than 0.");
        }

        double total = vehicle.hitungHarga(hari);
        vehicle.sewa();
        sudahSewa++;

        System.out.println("\n=== RENTAL BERHASIL ===");
        System.out.println("Customer  : " + nama);
        System.out.println("Kendaraan : " + vehicle.getMerk());
        System.out.println("Nomor     : " + vehicle.getNk());
        System.out.println("Durasi    : " + hari + " hari");
        System.out.println("Total     : Rp" + String.format("%,.0f", total));
        System.out.println("Status    : " + vehicle.getStatus());

        return total;
    }

    public void kembalikanKendaraan(String nk) 
            throws VehicleNotFoundException, VehicleNotAvailableException {

        Vehicle vehicle = cariKendaraan(nk);

        if (vehicle == null) {
            throw new VehicleNotFoundException("Vehicle " + nk + " was not found.");
        }

        if (vehicle.isStatus()) {
            throw new VehicleNotAvailableException("Kendaraan " + nk + " tidak sedang dirental.");
        }

        vehicle.kembalikanKendaraan();
        sudahSewa--;

        System.out.println("\n=== KENDARAAN DIKEMBALIKAN ===");
        System.out.println("Customer  : " + nama);
        System.out.println("Kendaraan : " + vehicle.getMerk());
        System.out.println("Nomor     : " + vehicle.getNk());
        System.out.println("Status    : " + vehicle.getStatus());
    }
}