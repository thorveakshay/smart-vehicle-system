package com.akshaythorve.smartvehicle.repository;

import com.akshaythorve.smartvehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vehicleRepository")
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
