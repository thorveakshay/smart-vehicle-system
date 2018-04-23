package com.akshaythorve.mitchell.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshaythorve.mitchell.model.Vehicle;
import com.akshaythorve.mitchell.repository.VehicleRepository;

@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public List<Vehicle> getAllVehicle() {
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle getVehicleById(int id) {
		return vehicleRepository.findOne(id);
	}

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public void removeVehicle(Vehicle vehicle) {
		vehicleRepository.delete(vehicle);
	}
	

}
