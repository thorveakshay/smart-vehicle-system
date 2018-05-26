package com.akshaythorve.smartvehicle.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle {

    /*
     * adding @JsonProperty for Spring REST consuming JSON uppercase letters
     */

    @Id
    @GeneratedValue
    @JsonProperty("Id")
    public int Id;

    @JsonProperty("Year")
    public int Year;
    @JsonProperty("Make")
    public String Make;

    @JsonProperty("Model")
    public String Model;

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

    public Vehicle(int year, String make, String model) {
        super();
        Year = year;
        Make = make;
        Model = model;
    }

    @JsonProperty("Id")
    public int getId() {
        return Id;
    }

    @JsonProperty("Id")
    public void setId(int id) {
        Id = id;
    }

    @JsonProperty("Year")
    public int getYear() {
        return Year;
    }

    @JsonProperty("Year")
    public void setYear(int year) {
        Year = year;
    }

    @JsonProperty("Make")
    public String getMake() {
        return Make;
    }

    @JsonProperty("Make")
    public void setMake(String make) {
        Make = make;
    }

    @JsonProperty("Model")
    public String getModel() {
        return Model;
    }

    @JsonProperty("Model")
    public void setModel(String model) {
        Model = model;
    }
}
