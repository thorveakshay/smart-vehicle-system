package com.akshaythorve.mitchell.service;

import com.akshaythorve.mitchell.model.Vehicle;
import com.akshaythorve.mitchell.repository.VehicleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllVehicle() {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        vehicleList.add(new Vehicle(2000, "Ford", "Focus"));
        vehicleList.add(new Vehicle(2018, "Ford", "Mustang"));
        vehicleList.add(new Vehicle(2016, "Tesla", "ModelX"));
        when(vehicleRepository.findAll()).thenReturn(vehicleList);

        List<Vehicle> result = vehicleService.getAllVehicle();
        assertEquals(3, result.size());
    }

    @Test
    public void testGetVehicleById() {
        Vehicle vehicle = new Vehicle(2000, "Ford", "Focus");
        when(vehicleRepository.findOne(4)).thenReturn(vehicle);
        Vehicle result = vehicleService.getVehicleById(4);
        assertEquals(2000, result.getYear());
        assertEquals("Ford", result.getMake());
        assertEquals("Focus", result.getModel());
    }

    @Test
    public void saveVehicle() {
        Vehicle vehicle = new Vehicle(2000, "Ford", "Fusion");
        when(vehicleRepository.save(vehicle)).thenReturn(vehicle);
        Vehicle result = vehicleService.saveVehicle(vehicle);
        assertEquals(2000, result.getYear());
        assertEquals("Ford", result.getMake());
        assertEquals("Fusion", result.getModel());
    }

    @Test
    public void removeVehicle() {
        Vehicle vehicle = new Vehicle(2000, "Ford", "Fusion");
        vehicleService.removeVehicle(vehicle);
        verify(vehicleRepository, times(1)).delete(vehicle);
    }


}

