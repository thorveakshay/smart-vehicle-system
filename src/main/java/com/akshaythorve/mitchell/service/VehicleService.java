package com.akshaythorve.mitchell.service;

import java.util.List;

import com.akshaythorve.mitchell.model.Vehicle;

public interface VehicleService {
	public List<Vehicle> getAllVehicle();
	public Vehicle getVehicleById(int id);
	public Vehicle saveVehicle(Vehicle vehicle);
	public void removeVehicle(Vehicle vehicle);
}
