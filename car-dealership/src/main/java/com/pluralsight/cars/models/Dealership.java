package com.pluralsight.cars.models;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();

    //Blank constructor to create a new Dealership object when values aren't known
    public Dealership() {}

    //Constructor to create a new Dealership object when values are known
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    //Non-static methods for Dealership processing requests
    public void getVehiclesByPrice(double min, double max) {
        System.out.println("Dealership: " + name);
        System.out.println(String.format("%-10s %-10s %-10s %-15s %-12s %-10s %-12s %-12s", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price"));

        for (Vehicle v: inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                System.out.println(v);
            } else if (min < v.getPrice() || max < v.getPrice()) {
                System.out.println("No vehicles matched your provided price range.");
                break;
            } else {
                System.out.println("Result: Cannot find vehicle in your price range. Please try again.");
                break;
            }
        }
    }

    public void getVehiclesByMakeModel(String make, String model) {
        System.out.println("Dealership: " + name);
        System.out.println(String.format("%-10s %-10s %-10s %-15s %-12s %-10s %-12s %-12s", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price"));

        for (Vehicle v: inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                System.out.println(v);
            }
        }
    }

    public void getVehiclesByYear(int year) {

    }

    public void getVehiclesByColor(String color) {

    }

    public void getVehiclesByMileage(int odometer) {

    }

    public void getVehiclesByVehicleType(String vehicleType) {

    }

    public void getAllVehicles() {
        System.out.println("Inventory for dealership: " + name);
        System.out.println(String.format("%-10s %-10s %-10s %-15s %-12s %-10s %-12s %-12s", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price"));
        for (Vehicle v: inventory) {
            System.out.println(v.toString());
        }
    }

    public void addVehicle(Vehicle v) {

    }

    public void removeVehicle(Vehicle v) {

    }
    @Override
    public String toString() {
        return String.format("%-12s, %-15s, %-12s", name, address, phone);
    }
}
