package com.akshaythorve.smartvehicle.web;

import com.akshaythorve.smartvehicle.exception.VehicleException;
import com.akshaythorve.smartvehicle.model.Response;
import com.akshaythorve.smartvehicle.model.Vehicle;
import com.akshaythorve.smartvehicle.service.VehicleService;
import com.akshaythorve.smartvehicle.util.PayloadValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@RestController
public class VehicleController extends WebMvcConfigurerAdapter {

    // added to support for CORS i.e multi-domain access
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public ResponseEntity<List<Vehicle>> getAllVehicle() {
        logger.info("Returning all the Vehicle´s");
        return new ResponseEntity<List<Vehicle>>(vehicleService.getAllVehicle(), HttpStatus.OK);
    }

    @RequestMapping(value = "/vehicles/{id}", method = RequestMethod.GET)
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") int id) throws VehicleException {
        logger.info("Vehicle id to return " + id);
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle == null || vehicle.getId() <= 0) {
            throw new VehicleException("Vehicle doesn´t exist");
        }
        return new ResponseEntity<Vehicle>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/vehicles/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> removeVehicleById(@PathVariable("id") int id) throws VehicleException {
        logger.info("Vehicle id to remove " + id);
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle == null || vehicle.getId() <= 0) {
            throw new VehicleException("Vehicle doesn´t exist to delete");
        }
        vehicleService.removeVehicle(vehicle);
        return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Vehicle has been deleted"), HttpStatus.OK);
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.POST)
    public ResponseEntity<Vehicle> saveVehicle(@RequestBody Vehicle payload) throws VehicleException {
        logger.info("Payload to save " + payload);
        System.out.println(payload.getMake() + "<-- make -- model --> " + payload.getModel());
        if (!PayloadValidator.validateCreatePayload(payload)) {
            throw new VehicleException("Error in request , id must not be defined");
        }
        return new ResponseEntity<Vehicle>(vehicleService.saveVehicle(payload), HttpStatus.OK);
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.PATCH)
    public ResponseEntity<Vehicle> updateVehicleData(@RequestBody Vehicle payload) throws VehicleException {
        logger.info("Payload to update " + payload);
        System.out.println(payload.getMake() + "<-- make -- model --> " + payload.getModel());
        Vehicle vehicle = vehicleService.getVehicleById(payload.getId());
        if (vehicle == null || vehicle.getId() <= 0) {
            throw new VehicleException("Vehicle doesn´t exist to update");
        }
        return new ResponseEntity<Vehicle>(vehicleService.saveVehicle(payload), HttpStatus.OK);
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.PUT)
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle payload) throws VehicleException {
        logger.info("Payload to update " + payload);
        System.out.println(payload.getMake() + "<-- make -- model --> " + payload.getModel());
        Vehicle vehicle = vehicleService.getVehicleById(payload.getId());
        if (vehicle == null || vehicle.getId() <= 0) {
            throw new VehicleException("Vehicle doesn´t exist to update");
        }
        return new ResponseEntity<Vehicle>(vehicleService.saveVehicle(payload), HttpStatus.OK);
    }

}
