package com.pluralsight.cars.models;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }


    public void getAllVehicles() {}

    public void addVehicle(Vehicle v) {
    }

}
