package com.akshaythorve.mitchell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.akshaythorve.mitchell.model.Vehicle;
import com.akshaythorve.mitchell.repository.VehicleRepository;

@SpringBootApplication
@EnableWebMvc
@Configuration
public class SpringSmartVehicleSystemApplication extends WebMvcConfigurerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringSmartVehicleSystemApplication.class);
	
	
	// added to support for CORS i.e multi-domain access
		@Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**");
	    }
		

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
