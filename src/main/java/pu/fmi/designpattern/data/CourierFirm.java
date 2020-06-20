package pu.fmi.designpattern.data;

import pu.fmi.designpattern.data.employee.ShipmentPackageHandler;

public class CourierFirm implements ShipmentPackageHandler {

    private final ShipmentPackageHandler handler;

    public CourierFirm(ShipmentPackageHandler handler) {
        this.handler = handler;
    }

    @Override
    public void handlePackage(ShipmentPackage shipmentPackage) {
        this.handler.handlePackage(shipmentPackage);
    }
}
