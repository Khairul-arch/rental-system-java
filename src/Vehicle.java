public abstract class Vehicle {
    private  String nk;
    private  String merk;
    private double harga;
    private boolean status;

    public Vehicle(String nk, String merk, double harga) {
        if (nk == null || nk.isBlank()) {
            throw new IllegalArgumentException("Nomor kendaraan tidak boleh kosong.");
        }
        if (merk == null || merk.isBlank()) {
            throw new IllegalArgumentException("Merk tidak boleh kosong.");
        }
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga per hari harus lebih dari 0.");
        }
        this.nk = nk;
        this.merk = merk;
        this.harga = harga;
        this.status = true;
    }

    public String getNk() { return nk; }
    public String getMerk() { return merk; }
    public double getHarga() { return harga; }
    public boolean isStatus() { return status; }

    public String getStatus() {
        return status ? "AVAILABLE" : "RENTED";
    }

    public void sewa() {
        if (!status) {
            throw new IllegalStateException("Kendaraan " + nk + " sedang disewa.");
        }
        status = false;
    }


    public void kembalikanKendaraan() {
        if (status) {
            throw new IllegalStateException("Kendaraan " + nk + " tidak sedang disewa.");
        }
        status = true;
    }

    
    public abstract double hitungHarga(int durasi);
    
    public abstract String getType();
    
    protected void cekHari(int durasi) {
        if (durasi <= 0) {
            throw new IllegalArgumentException("Lama sewa harus minimal 1 hari.");
        }
    }

    public void printStatus() {
        System.out.println("Nomor     : " + nk);
        System.out.println("Merk      : " + merk);
        System.out.println("Harga/hari: Rp" + String.format("%,.0f", harga));
        System.out.println("Status    : " + getStatus());
    }
}