package com.akshaythorve.mitchell.exception;

public class VehicleException extends Exception {

    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public VehicleException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public VehicleException() {
        super();
    }
}
