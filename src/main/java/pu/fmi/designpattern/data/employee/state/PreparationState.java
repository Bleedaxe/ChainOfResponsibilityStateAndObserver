package pu.fmi.designpattern.data.employee.state;

import pu.fmi.designpattern.data.employee.Employee;

public class PreparationState implements State {

    @Override
    public void handle(Employee context) {
        context.setState(new WaitingState());
    }
}
