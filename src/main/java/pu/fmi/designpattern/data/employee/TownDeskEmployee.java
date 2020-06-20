package pu.fmi.designpattern.data.employee;

import pu.fmi.designpattern.data.ShipmentPackage;
import pu.fmi.designpattern.data.ShipmentType;

import java.util.Optional;

public class TownDeskEmployee extends Employee {

    public TownDeskEmployee(Employee employee) {
        super(employee);
    }

    @Override
    protected boolean support(ShipmentPackage shipmentPackage) {
        return Optional.ofNullable(shipmentPackage)
                .map(ShipmentPackage::getType)
                .map(type -> type.equals(ShipmentType.TOWN))
                .orElse(false);
    }
}
