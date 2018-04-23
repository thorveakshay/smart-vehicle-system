package com.akshaythorve.mitchell.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue
	private int Id;
	private int Year;
	private String Make;
	private String Model;

    public Vehicle() {
		super();
	}

	public Vehicle(int id, int year, String make, String model) {
		super();
		Id = id;
		Year = year;
		Make = make;
		Model = model;
	}

	public Vehicle( int year, String make, String model) {
		super();
		Year = year;
		Make = make;
		Model = model;
	}
	
	public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }
}
