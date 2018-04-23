package com.akshaythorve.mitchell;

import com.akshaythorve.mitchell.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.akshaythorve.mitchell.repository.VehicleRepository;

@SpringBootApplication
public class SpringSmartVehicleSystemApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringSmartVehicleSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringSmartVehicleSystemApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(VehicleRepository vehicleRepository) {
		return (args) -> {
			vehicleRepository.save(new Vehicle(2000,"Ford", "Focus"));
			vehicleRepository.save(new Vehicle(2018,"Ford", "Mustang"));
			vehicleRepository.save(new Vehicle(2016,"Tesla", "ModelX"));
			vehicleRepository.save(new Vehicle(2018,"Tesla", "ModelS"));
			logger.info("Adding sample vehicles in to h2 database");
		};
	}
}
