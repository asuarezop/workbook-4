package com.pluralsight.cars.services;

import com.pluralsight.cars.app.DealershipApp;
import com.pluralsight.cars.models.Dealership;

import java.util.Scanner;

public class UserInterface {
    //Instance variable for Dealership object
    private static Dealership dealership;

    //Related to input from user
    static String userInput;

    //Initializing scanner to read from terminal input
    static Scanner inputSc = new Scanner(System.in);

    //Boolean condition to exit application screens
    static boolean exitApp = false;

    //Constructor to UserInterface
    public UserInterface(Dealership dealership) {
        UserInterface.dealership = dealership;
    }

    public void showHomeScreen() {
        String homeScreenMenuHeader = """
                =================================
                |      DEALERSHIP APP (HOME)    |
                =================================
                """;
        String prompt = """
                Please select what type of request to filter from dealership inventory:
                
                [1] Price - filter vehicles within a price range
                [2] Make Model - filter vehicles by make/model
                [3] Year - filter vehicles by year range
                [4] Color - filter vehicles by color
                [5] Mileage - filter vehicles by mileage range
                [6] Vehicle Type - filter vehicles by type (SUV, Sedan, Hatchback, etc.) 
                [7] All Vehicles - display every vehicle from inventory
                [8] Add Vehicle - adds a new vehicle to inventory
                [9] Remove Vehicle - removes a vehicle from inventory
                [10] Exit Application - quits running application
                """;

        do {
            System.out.println(homeScreenMenuHeader);
            System.out.println(prompt);
            userInput = inputSc.nextLine().trim();

            switch (userInput) {
                case "1":
                    System.out.println("Enter your desired price range to search vehicles from dealership.");
                    System.out.print("Minimum value: ");
                    userInput = inputSc.nextLine().trim();
                    double minPrice = Double.parseDouble(userInput);

                    System.out.print("Maximum value: ");
                    userInput = inputSc.nextLine().trim();
                    double maxPrice = Double.parseDouble(userInput);

                    processGetByPriceRequest(minPrice, maxPrice);
                    break;
                case "2":
                    System.out.println("Enter vehicle make and model to search vehicles from dealership.");
                    System.out.print("Make: ");
                    String vehicleMake = inputSc.nextLine().trim();

                    System.out.print("Model: ");
                    String vehicleModel = inputSc.nextLine().trim();

                    processGetByMakeModelRequest(vehicleMake, vehicleModel);
                    break;
                case "3":
                    System.out.println("Enter vehicle year to search vehicles from dealership.");
                    System.out.print("Year: ");
                    String vehicleYear = inputSc.nextLine().trim();
                    int parsedVehicleYear = Integer.parseInt(vehicleYear);

                    processGetByYearRequest(parsedVehicleYear);
                    break;
                case "4":
                    System.out.println("Enter vehicle color to search vehicles from dealership.");
                    System.out.print("Color: ");
                    String vehicleColor = inputSc.nextLine().trim();

                    processGetByColorRequest(vehicleColor);
                    break;
                case "5":
                    System.out.println("Enter your desired mileage range to search vehicles from dealership.");
                    System.out.print("Mileage: ");
                    String vehicleOdometer = inputSc.nextLine().trim();
                    int parsedVehicleOdometer = Integer.parseInt(vehicleOdometer);

                    processGetByMileageRequest(parsedVehicleOdometer);
                    break;
                case "6":
                    System.out.println("Enter vehicle type to search vehicles from dealership.");
                    System.out.print("Type: ");
                    String vehicleType = inputSc.nextLine().trim();

                    processGetByVehicleTypeRequest(vehicleType);
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
//                    Dealership.addVehicle();
                    break;
                case "9":
//                    Dealership.removeVehicle();
                    break;
                case "10":
                    exitApp = true;
                    break;
                default:
                    throw new Error("Sorry, that's not a valid option. Please make your selection.");
            }
        } while (!exitApp);

    }

    //Other non-static methods to process user requests
    public void processGetByPriceRequest(double min, double max) {
        if (min != 0 && max != 0) {
            UserInterface.dealership.getVehiclesByPrice(min, max);
        }
    }

    public void processGetByMakeModelRequest(String make, String model) {
        if (!make.isEmpty() && !model.isEmpty()) {
            UserInterface.dealership.getVehiclesByMakeModel(make, model);
        }
    }

    public void processGetByYearRequest(int year) {
        String parsedYear = String.valueOf(year);
        if (!parsedYear.isEmpty() && parsedYear.length() <= 4) {
            UserInterface.dealership.getVehiclesByYear(year);
        }
    }

    public void processGetByColorRequest(String color) {
        if (!color.isEmpty()) {
            UserInterface.dealership.getVehiclesByColor(color);
        }
    }

    public void processGetByMileageRequest(int odometer) {
        if (odometer != 0) {
            UserInterface.dealership.getVehiclesByMileage(odometer);
        }
    }

    public void processGetByVehicleTypeRequest(String vehicleType) {
        if (!vehicleType.isEmpty()) {
            UserInterface.dealership.getVehiclesByVehicleType(vehicleType);
        }
    }

    public void processGetAllVehiclesRequest() {
        UserInterface.dealership.getAllVehicles();
    }
}
