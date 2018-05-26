package com.akshaythorve.smartvehicle.service;

import com.akshaythorve.smartvehicle.model.Vehicle;

import java.util.List;

public interface VehicleService {
    public List<Vehicle> getAllVehicle();

    public Vehicle getVehicleById(int id);

    public Vehicle saveVehicle(Vehicle vehicle);

    public void removeVehicle(Vehicle vehicle);
}
