package pu.fmi.designpattern.exception;

import pu.fmi.designpattern.data.ShipmentPackage;

public class UnsupportedPackageException extends RuntimeException {

    private final static String MESSAGE_TEMPLATE = "Handler for customer %s is not found!";

    public UnsupportedPackageException(ShipmentPackage shipmentPackage) {
        super(String.format(MESSAGE_TEMPLATE, shipmentPackage.toString()));
    }
}
