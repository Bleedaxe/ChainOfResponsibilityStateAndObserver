package pu.fmi.designpattern.data.employee;

import pu.fmi.designpattern.data.ShipmentPackage;
import pu.fmi.designpattern.data.ShipmentType;

import java.util.Optional;

public class CountryDeskEmployee extends Employee {

    public CountryDeskEmployee(Employee employee) {
        super(employee);
    }

    @Override
    protected boolean support(ShipmentPackage shipmentPackage) {
        return Optional.ofNullable(shipmentPackage)
                .map(ShipmentPackage::getType)
                .map(type -> type.equals(ShipmentType.COUNTRY))
                .orElse(false);
    }
}
