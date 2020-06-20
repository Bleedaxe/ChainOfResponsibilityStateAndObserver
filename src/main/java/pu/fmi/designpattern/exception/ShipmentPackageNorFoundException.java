package pu.fmi.designpattern.exception;

public class ShipmentPackageNorFoundException extends RuntimeException {

    private static final String MESSAGE = "Shipment package is not present in the employee";

    public ShipmentPackageNorFoundException() {
        super(MESSAGE);
    }
}
