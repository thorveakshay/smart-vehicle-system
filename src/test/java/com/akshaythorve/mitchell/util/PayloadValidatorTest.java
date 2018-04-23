package com.akshaythorve.mitchell.util;

import com.akshaythorve.mitchell.exception.VehicleException;
import com.akshaythorve.mitchell.model.Vehicle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayloadValidatorTest {

    @Test
    public void validatePayLoad() throws VehicleException {
        Vehicle vehicle = new Vehicle(1950, "Ford", "Fusion");
        assertEquals(true, PayloadValidator.validateCreatePayload(vehicle));
    }

    @Test
    public void validateInvalidPayLoad() throws VehicleException{
        Vehicle vehicle = new Vehicle(2016, "Ford", "Fusion");
        assertEquals(true, PayloadValidator.validateCreatePayload(vehicle));
    }


}
