package com.akshaythorve.smartvehicle.util;

import com.akshaythorve.smartvehicle.exception.VehicleException;
import com.akshaythorve.smartvehicle.model.Vehicle;

public class PayloadValidator {

	public static boolean validateCreatePayload(Vehicle vehicle) throws VehicleException {
		if (vehicle.getId() > 0 || vehicle == null){
			return false;
		}

		if (vehicle != null) {
			System.out.println("vehicle.getYear(): "+vehicle.getYear() +"vehicle.getMake() :"+vehicle.getMake());
			if (!(vehicle.getYear() >= 1950 && vehicle.getYear() <= 2050)) {
                throw new VehicleException("Error in request, please enter year between 1950 to 2050.");

			} else if (vehicle.getMake()==null ||vehicle.getMake().equals(null) || vehicle.getMake().equals("")
					|| vehicle.getMake().length() > 100) {

                throw new VehicleException("Error in request, Please enter correct value for Make.");
			} else if (vehicle.getModel().equals(null) || vehicle.getModel().equals("")
					|| vehicle.getModel().length() > 100) {

                throw new VehicleException("Error in request, Please enter correct value for Model.");
			}

		}


		return true;
	}

}
