package com.akshaythorve.mitchell.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.akshaythorve.mitchell.model.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.akshaythorve.mitchell.repository.VehicleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class VehicleServiceTest {
	
	@Mock
	private VehicleRepository vehicleRepository;
	
	@InjectMocks
	private VehicleServiceImpl vehicleService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllVehicle(){
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		vehicleList.add(new Vehicle(2000,"Ford", "Focus"));
		vehicleList.add(new Vehicle(2018,"Ford", "Mustang"));
		vehicleList.add(new Vehicle(2016,"Tesla", "ModelX"));
		when(vehicleRepository.findAll()).thenReturn(vehicleList);
		
		List<Vehicle> result = vehicleService.getAllVehicle();
		assertEquals(3, result.size());
	}
	
	@Test
	public void testGetVehicleById(){
		Vehicle vehicle = new Vehicle(2000,"Ford", "Focus");
		when(vehicleRepository.findOne(2000)).thenReturn(vehicle);
		Vehicle result = vehicleService.getVehicleById(1);
		assertEquals(2000, result.getYear());
		assertEquals("Ford", result.getMake());
		assertEquals("Focus", result.getModel());
	}
	
	@Test
	public void saveVehicle(){
		Vehicle vehicle = new Vehicle(8,"Todo Sample 8","tata");
		when(vehicleRepository.save(vehicle)).thenReturn(vehicle);
		Vehicle result = vehicleService.saveVehicle(vehicle);
		assertEquals(8, result.getId());
		assertEquals("Todo Sample 8", result.getMake());
		assertEquals(true, result.getModel());
	}
	
	@Test
	public void removeVehicle(){
		Vehicle vehicle = new Vehicle(8,"Todo Sample 8","tata");
		vehicleService.removeVehicle(vehicle);
        verify(vehicleRepository, times(1)).delete(vehicle);
	}
	
	

}

