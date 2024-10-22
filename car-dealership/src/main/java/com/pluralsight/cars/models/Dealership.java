package com.pluralsight.cars.models;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    //Methods for search vehicles, add/remove vehicles
    public static void getVehicleByPrice(double min, double max) {

    }

    public static void getVehicleByMakeModel(String make, String model) {}
    public static void getVehicleByYear(int year) {}
    public static void getVehicleByColor(String color) {}
    public static void getVehicleByMileage(int min, int max) {}
    public static void getVehicleByType(String vehicleType) {}
    public static void getAllVehicles() {}

    public static void addVehicle(Vehicle v) {

    }

    public static void removeVehicle(Vehicle v) {

    }
}
