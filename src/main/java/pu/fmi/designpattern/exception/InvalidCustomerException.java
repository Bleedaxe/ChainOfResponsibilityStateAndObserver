package pu.fmi.designpattern.exception;

public class InvalidCustomerException extends RuntimeException {

    private static final String MESSAGE = "Given customer is null";

    public InvalidCustomerException() {
        super(MESSAGE);
    }
}
