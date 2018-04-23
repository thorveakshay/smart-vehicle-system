package com.akshaythorve.mitchell.web;

import java.util.List;

import com.akshaythorve.mitchell.exception.VehicleException;
import com.akshaythorve.mitchell.model.Response;
import com.akshaythorve.mitchell.model.Vehicle;
import com.akshaythorve.mitchell.service.VehicleService;
import com.akshaythorve.mitchell.util.PayloadValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {
	
	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value="/vehicles", method=RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> getAllVehicle(){
    	logger.info("Returning all the Vehicle´s");
		return new ResponseEntity<List<Vehicle>>(vehicleService.getAllVehicle(), HttpStatus.OK);
	}
	
    @RequestMapping(value = "/vehicles/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") int id) throws VehicleException {
    	logger.info("Vehicle id to return " + id);
    	Vehicle vehicle = vehicleService.getVehicleById(id);
    	if (vehicle == null || vehicle.getId() <= 0){
            throw new VehicleException("Vehicle doesn´t exist");
    	}
		return new ResponseEntity<Vehicle>(vehicleService.getVehicleById(id), HttpStatus.OK);
	}

    @RequestMapping(value = "/vehicles/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> removeVehicleById(@PathVariable("id") int id) throws VehicleException{
    	logger.info("Vehicle id to remove " + id);
    	Vehicle vehicle = vehicleService.getVehicleById(id);
    	if (vehicle == null || vehicle.getId() <= 0){
            throw new VehicleException("Vehicle doesn´t exist to delete");
    	}
		vehicleService.removeVehicle(vehicle);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Vehicle has been deleted"), HttpStatus.OK);
	}
    
    @RequestMapping(value = "/vehicles", method = RequestMethod.POST)
   	public ResponseEntity<Vehicle> saveVehicle(@RequestBody Vehicle payload) throws VehicleException{
    	logger.info("Payload to save " + payload);
    	if (!PayloadValidator.validateCreatePayload(payload)){
            throw new VehicleException("Error in request , id must not be defined");
    	}
		return new ResponseEntity<Vehicle>(vehicleService.saveVehicle(payload), HttpStatus.OK);
   	}
    
    @RequestMapping(value = "/vehicles", method = RequestMethod.PATCH)
   	public ResponseEntity<Vehicle>  updateVehicle(@RequestBody Vehicle payload) throws VehicleException{
    	logger.info("Payload to update " + payload);
    	Vehicle vehicle = vehicleService.getVehicleById(payload.getId());
    	if (vehicle == null || vehicle.getId() <= 0){
            throw new VehicleException("Vehicle doesn´t exist to update");
    	}
		return new ResponseEntity<Vehicle>(vehicleService.saveVehicle(payload), HttpStatus.OK);
   	}
	
}
