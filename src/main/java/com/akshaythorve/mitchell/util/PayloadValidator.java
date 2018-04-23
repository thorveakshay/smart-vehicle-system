package com.akshaythorve.mitchell.util;

import com.akshaythorve.mitchell.model.Vehicle;

public class PayloadValidator {
	
	public static boolean validateCreatePayload(Vehicle vehicle){
		if (vehicle.getId() > 0){
			return false;
		}
		return true;
	}

}
