package com.pluralsight.cars.models;
import java.util.ArrayList;

public class Dealership {
    private final String name;
    private final String address;
    private final String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();

    //Constructor to create a new Dealership object
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    //Non-static methods for Dealership processing requests
    public void getVehiclesByPrice(double min, double max) {
        System.out.println(String.format("%-10s %-10s %-10s %-15s %-12s %-10s %-12s %-12s", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price"));

        for (Vehicle v: inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                System.out.println(v);
            } else if (min < v.getPrice() || max < v.getPrice()) {
                System.out.println("No vehicles matched your provided price range.");
                break;
            }
        }
    }

    public void getVehiclesByMakeModel(String make, String model) {
        System.out.println(String.format("%-10s %-10s %-10s %-15s %-12s %-10s %-12s %-12s", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price"));

        for (Vehicle v: inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                System.out.println(v);
                break;
            }
        }
    }

    public void getVehiclesByYear(int year) {
        System.out.println(String.format("%-10s %-10s %-10s %-15s %-12s %-10s %-12s %-12s", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price"));

        for (Vehicle v: inventory) {
            if (v.getYear() == year) {
                System.out.println(v);
                break;
            }
        }
    }

    //Bugged at the moment when adding else with error message
    public void getVehiclesByColor(String color) {
        System.out.println("Dealership: " + name);
        System.out.println(String.format("%-10s %-10s %-10s %-15s %-12s %-10s %-12s %-12s", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price"));

        for (Vehicle v: inventory) {
           if (v.getColor().equalsIgnoreCase(color)) {
               System.out.println(v);
           }
        }
    }

    public void getVehiclesByMileage(int odometer) {
        System.out.println(String.format("%-10s %-10s %-10s %-15s %-12s %-10s %-12s %-12s", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price"));

        for (Vehicle v: inventory) {
            if (v.getOdometer() == odometer) {
                System.out.println(v);
            }
        }
    }

    public void getVehiclesByVehicleType(String vehicleType) {
        System.out.println(String.format("%-10s %-10s %-10s %-15s %-12s %-10s %-12s %-12s", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price"));

        for (Vehicle v: inventory) {
            if (v.getVehicleType().equalsIgnoreCase(vehicleType)) {
                System.out.println(v);
            }
        }
    }

    public void getAllVehicles() {
        System.out.println(String.format("%-10s %-10s %-10s %-15s %-12s %-10s %-12s %-12s", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price"));
        for (Vehicle v: inventory) {
            System.out.println(v.toString());
        }
    }

    public void addVehicle(Vehicle v) {
        inventory.add(v);
        //Confirmation message
        System.out.println("Vehicle was added to current inventory!");
    }

    public void removeVehicle(Vehicle v) {
        //Removing vehicle if it matches VIN inside current dealership inventory
        inventory.removeIf(c -> c.getVin() == v.getVin());
        //Confirmation message
        System.out.println("Vehicle removed from dealership.");
    }

    @Override
    public String toString() {
        return String.format("%-12s, %-15s, %-12s", name, address, phone);
    }
}
