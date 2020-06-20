package pu.fmi.designpattern;

import lombok.extern.slf4j.Slf4j;
import pu.fmi.designpattern.data.CourierFirm;
import pu.fmi.designpattern.data.ShipmentPackage;
import pu.fmi.designpattern.data.WarehouseBoy;
import pu.fmi.designpattern.data.employee.AbroadCountryDeskEmployee;
import pu.fmi.designpattern.data.employee.CountryDeskEmployee;
import pu.fmi.designpattern.data.employee.ShipmentPackageHandler;
import pu.fmi.designpattern.data.employee.TownDeskEmployee;

import static pu.fmi.designpattern.data.ShipmentType.*;

@Slf4j
public class Application {

    public static void main(String[] args) {
        WarehouseBoy warehouseBoy = new WarehouseBoy();
        CourierFirm courierFirm = new CourierFirm(getShipmentHandler(warehouseBoy));

        giveShipmentPackage(courierFirm, new ShipmentPackage(TOWN));
        giveShipmentPackage(courierFirm, new ShipmentPackage(ABROAD_COUNTRY));
        giveShipmentPackage(courierFirm, new ShipmentPackage(ABROAD_COUNTRY));
        giveShipmentPackage(courierFirm, new ShipmentPackage(COUNTRY));
        giveShipmentPackage(courierFirm, new ShipmentPackage(TOWN));
        giveShipmentPackage(courierFirm, new ShipmentPackage(ABROAD_COUNTRY));
    }

    private static void giveShipmentPackage(CourierFirm courierFirm, ShipmentPackage shipmentPackage) {
        courierFirm.handlePackage(shipmentPackage);
    }

    private static ShipmentPackageHandler getShipmentHandler(WarehouseBoy warehouseBoy) {
        TownDeskEmployee townDeskEmployee = new TownDeskEmployee(null);
        townDeskEmployee.addObserver(warehouseBoy);

        CountryDeskEmployee countryDeskEmployee = new CountryDeskEmployee(townDeskEmployee);
        countryDeskEmployee.addObserver(warehouseBoy);

        AbroadCountryDeskEmployee abroadCountryDeskEmployee = new AbroadCountryDeskEmployee(countryDeskEmployee);
        abroadCountryDeskEmployee.addObserver(warehouseBoy);

        return abroadCountryDeskEmployee;
    }
}
