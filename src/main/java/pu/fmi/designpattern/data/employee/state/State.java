package pu.fmi.designpattern.data.employee.state;

import pu.fmi.designpattern.data.employee.Employee;

public interface State {
    void handle(Employee context);
}
