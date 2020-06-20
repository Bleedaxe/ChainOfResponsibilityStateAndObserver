package pu.fmi.designpattern.data.employee;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pu.fmi.designpattern.data.ShipmentPackage;
import pu.fmi.designpattern.data.employee.state.State;
import pu.fmi.designpattern.data.employee.state.WaitingState;
import pu.fmi.designpattern.exception.UnsupportedPackageException;

import java.util.Observable;

@Slf4j
public abstract class Employee extends Observable implements ShipmentPackageHandler {

    @Getter
    @Setter
    private ShipmentPackage shipmentPackage;
    protected State currentState;
    protected Employee next;

    protected Employee() {
        this(null);
    }

    protected Employee(Employee next) {
        this.next = next;
        this.setState(new WaitingState());
    }

    public void handlePackage(ShipmentPackage shipmentPackage) {
        if (support(shipmentPackage)) {
            log.info("{} handled package {}", getClass().getName(), shipmentPackage.toString());
            this.shipmentPackage = shipmentPackage;
            currentState.handle(this);
        } else {
            if (next == null) {
                throw new UnsupportedPackageException(shipmentPackage);
            }
            next.handlePackage(shipmentPackage);
        }
    }

    public void setState(State state) {
        this.currentState = state;
        setChanged();
        notifyObservers(state);
    }

    protected abstract boolean support(ShipmentPackage shipmentPackage);
}
