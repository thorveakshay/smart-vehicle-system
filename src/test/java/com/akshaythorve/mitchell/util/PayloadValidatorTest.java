package com.akshaythorve.mitchell.util;

import static org.junit.Assert.assertEquals;

import com.akshaythorve.mitchell.model.Vehicle;
import org.junit.Test;

public class PayloadValidatorTest {

	@Test
	public void validatePayLoad() {
		Vehicle vehicle = new Vehicle(1, "Sample Vehicle 1", "tata");
		assertEquals(false, PayloadValidator.validateCreatePayload(vehicle));
	}
	
	@Test
	public void validateInvalidPayLoad() {
		Vehicle vehicle = new Vehicle(0, "Sample Vehicle 1", "tata");
		assertEquals(true, PayloadValidator.validateCreatePayload(vehicle));
	}
	
	

}
