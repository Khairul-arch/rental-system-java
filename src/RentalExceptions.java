
class VehicleNotFoundException extends Exception {
    public VehicleNotFoundException(String message) {
        super(message);
    }
}

class VehicleNotAvailableException extends Exception {
    public VehicleNotAvailableException(String message) {
        super(message);
    }
}

class InvalidRentalDurationException extends Exception {
    public InvalidRentalDurationException(String message) {
        super(message);
    }
}

class RentalLimitExceededException extends Exception {
    public RentalLimitExceededException(String message) {
        super(message);
    }
}