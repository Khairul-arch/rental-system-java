public class Main {

    public static void main(String[] args) {

        RentalSystem rental = new RentalSystem("Ikmah");

        Motor motor1 = new Motor("B1234ABC", "Honda", 20000);
        Motor motor2 = new Motor("B5678ABC", "Yamaha", 25000);
        Car car1 = new Car("B1111XYZ", "Toyota", 100000);
        Truck truck1 = new Truck("B2222TRK", "Hino", 800000);
        ElectricCar electricCar1 = new ElectricCar("B3333ELC", "Tesla", 500000);

        rental.tambahKendaraan(motor1);
        rental.tambahKendaraan(motor2);
        rental.tambahKendaraan(car1);
        rental.tambahKendaraan(truck1);
        rental.tambahKendaraan(electricCar1);

        try {
            rental.sewaKendaraan("B9999XYZ", 2);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            rental.sewaKendaraan("B1234ABC", 2);
            rental.sewaKendaraan("B1234ABC", 2);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            rental.sewaKendaraan("B5678ABC", 0);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            rental.sewaKendaraan("B5678ABC", -5);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            rental.sewaKendaraan("B1111XYZ", 1);
            rental.sewaKendaraan("B2222TRK", 1);
            rental.sewaKendaraan("B3333ELC", 1);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            rental.kembalikanKendaraan("B1234ABC");
            rental.kembalikanKendaraan("B1234ABC");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}