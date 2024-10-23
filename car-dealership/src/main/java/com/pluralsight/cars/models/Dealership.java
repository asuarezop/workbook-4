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

    public static void getVehiclesByPrice (double min, double max) {

    }
    public static void getVehiclesByMakeModel (String make, String model) {

    }
    public static void getVehiclesByYear (int year) {

    }
    public static void getVehiclesByColor (String color) {

    }
    public static void getVehiclesByMileage(int odometer) {

    }
    public static void getVehiclesByVehicleType(String vehicleType) {

    }
    public static void getAllVehicles() {

    }
    public static void addVehicle(Vehicle v) {

    }
    public static void removeVehicle(Vehicle v) {

    }
}
