package com.akshaythorve.mitchell.service;

import com.akshaythorve.mitchell.model.Vehicle;

import java.util.List;

public interface VehicleService {
    public List<Vehicle> getAllVehicle();

    public Vehicle getVehicleById(int id);

    public Vehicle saveVehicle(Vehicle vehicle);

    public void removeVehicle(Vehicle vehicle);
}
