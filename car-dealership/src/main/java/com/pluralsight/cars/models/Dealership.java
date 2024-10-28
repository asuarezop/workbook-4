package com.pluralsight.cars.models;
import JavaHelpers.ColorCodes;
import com.pluralsight.cars.services.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private final ArrayList<Vehicle> inventory = new ArrayList<>();

    //Blank constructor for when values aren't known
    public Dealership() {}

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

    //Non-static methods for Dealership processing requests
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle v: inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                results.add(v);
            }
        }
        return results;
    }

    public void getVehiclesByMakeModel(String make, String model) {

        for (Vehicle v: inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                System.out.println(v);
            } else {
                System.out.println("No vehicles matched your provided make/model.");
            }
            break;
        }
    }

    public void getVehiclesByYear(int year) {
        UserInterface.printDealershipHeader();
        for (Vehicle v: inventory) {
            if (v.getYear() == year) {
                System.out.println(v);
            } else {
                System.out.println("No vehicles matched given year.");
            }
            break;
        }
    }

    //Bugged at the moment when adding else with error message
    public void getVehiclesByColor(String color) {
        UserInterface.printDealershipHeader();
        for (Vehicle v: inventory) {
           if (v.getColor().equalsIgnoreCase(color)) {
               System.out.println(v);
           }
        }
        System.out.println("No vehicles found that match given color.");
    }

    public void getVehiclesByMileage(int min, int max) {
        UserInterface.printDealershipHeader();
        for (Vehicle v: inventory) {
            if (v.getOdometer() >= min && v.getOdometer() <= max) {
                System.out.println(v);
            }

//            if (inventory.stream().filter(c -> c.getOdometer() >= min && c.getOdometer() <= max))
//            else if (min < v.getOdometer() || max < v.getOdometer()) {
//                break;
//            }

        }

        System.out.println("No vehicles found that match provided mileage range.");
    }

    public void getVehiclesByVehicleType(String vehicleType) {
        UserInterface.printDealershipHeader();
        for (Vehicle v: inventory) {
            if (v.getVehicleType().equalsIgnoreCase(vehicleType)) {
                System.out.println(v);
            }
        }
    }

    public void getAllVehicles() {
        UserInterface.printDealershipHeader();
        for (Vehicle v: inventory) {
            System.out.println(v);
        }
    }

    public void addVehicle(Vehicle v) {
        inventory.add(v);
        //Confirmation message
        System.out.println(ColorCodes.SUCCESS + ColorCodes.ITALIC + "Vehicle was added to current inventory!" + ColorCodes.RESET);
    }

    public void removeVehicle(Vehicle v) {
        //Removing vehicle if it matches VIN inside current dealership inventory
        inventory.removeIf(c -> c.getVin() == v.getVin());
        //Confirmation message
        System.out.println(ColorCodes.SUCCESS + ColorCodes.ITALIC + "Vehicle removed from dealership." + ColorCodes.RESET);
    }

    @Override
    public String toString() {
        return String.format("%-12s, %-15s, %-12s", name, address, phone);
    }
}
