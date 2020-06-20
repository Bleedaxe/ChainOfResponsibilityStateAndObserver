package pu.fmi.designpattern.data.employee.state;

import pu.fmi.designpattern.data.employee.Employee;

public class WaitingState implements State {

    @Override
    public void handle(Employee context) {
        context.setState(new PreparationState());
    }
}
