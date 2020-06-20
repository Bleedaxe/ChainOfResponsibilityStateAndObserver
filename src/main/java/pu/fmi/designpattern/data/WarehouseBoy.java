package pu.fmi.designpattern.data;

import lombok.extern.slf4j.Slf4j;
import pu.fmi.designpattern.data.employee.Employee;
import pu.fmi.designpattern.data.employee.state.PreparationState;
import pu.fmi.designpattern.data.employee.state.WaitingState;
import pu.fmi.designpattern.exception.ShipmentPackageNorFoundException;

import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

@Slf4j
public class WarehouseBoy implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof PreparationState && o instanceof Employee) {
            Employee employee = (Employee) o;
            ShipmentPackage shipmentPackage = Optional.ofNullable(employee.getShipmentPackage())
                    .orElseThrow(ShipmentPackageNorFoundException::new);
            log.info("Warehouse boy got package {}", shipmentPackage.toString());

            employee.setShipmentPackage(null);
            employee.setState(new WaitingState());
        }
    }
}
