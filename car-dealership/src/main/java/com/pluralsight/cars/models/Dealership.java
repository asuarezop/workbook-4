package com.pluralsight.cars.models;

import com.pluralsight.cars.services.DealershipFileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(){

    }

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

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

    public void getVehiclesByPrice(double min, double max) {

    }

    public void getVehiclesByMakeModel(String make, String model) {

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

//        try {
//            //Calling openFileReader method to initialize BufferedReader
//            BufferedReader bufReader = DealershipFileManager.openFileReader(filename);
//
//            //Reading each line of input from fileContents
//            String fileContents;
//
//            //Skip the first line of file (header)
//            bufReader.readLine();
//
//            while ((fileContents = bufReader.readLine()) != null) {
//                String[] dealershipData = fileContents.split("\\|");
//
//                //Passing in vehicle data into new ArrayList of vehicles
//                int vin = Integer.parseInt(dealershipData[0]);
//                int year = Integer.parseInt(dealershipData[1]);
//                String make = dealershipData[2];
//                String model = dealershipData[3];
//                String type = dealershipData[4];
//                String color = dealershipData[5];
//                int miles = Integer.parseInt(dealershipData[6]);
//                double price = Double.parseDouble(dealershipData[7]);
//
//                v = new Vehicle(vin, year, make, model, type, color, miles, price);
//
//                //Adding each vehicle inside file to inventory ArrayList
//                inventory.add(v);
//            }
//
//            //Successfully read file message
//            System.out.println("File was successfully read!");
//
//            //Closing bufReader
//            bufReader.close();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
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
