package com.pluralsight.cars.services;

import JavaHelpers.ColorCodes;
import com.pluralsight.cars.models.Dealership;
import com.pluralsight.cars.models.Vehicle;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    //Instance variable for Dealership object
    private Dealership dealership;

    //String variable to hold inventory CSV file path
    public static final String inventoryCSV = "src/main/resources/inventory.csv";

    //Related to input from user
    static String userInput;

    //Initializing scanner to read from terminal input
    static Scanner inputSc = new Scanner(System.in);

    //Boolean condition to exit application screens
    static boolean exitApp = false;

    //init(): This method gets called first before any other methods are run inside main()
    private void init() {
        //To get a new dealership object and have object initialized with returned dealership
        this.dealership = DealershipFileManager.getDealership();
    }

    public void showHomeScreen() throws IOException {
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
            init();
            System.out.println(homeScreenMenuHeader);
            System.out.println(prompt);
            userInput = inputSc.nextLine().trim();

            switch (userInput) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
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
    public void processGetByPriceRequest() {
        promptInstructions("Enter your desired price range to search vehicles from:  " + dealership.getName());

        String min = promptUser("Minimum value: ");
        double minPrice = Double.parseDouble(min);

        String max = promptUser("Maximum value: ");
        double maxPrice = Double.parseDouble(max);

        if (minPrice != 0 && maxPrice != 0) {
            dealership.getVehiclesByPrice(minPrice, maxPrice);
        }
    }

    public void processGetByMakeModelRequest() {
        promptInstructions("Enter vehicle make and model to search vehicles from:  " + dealership.getName());
        String vehicleMake = promptUser("Make: ");
        String vehicleModel = promptUser("Model: ");

        if (!vehicleMake.isEmpty() && !vehicleModel.isEmpty()) {
            dealership.getVehiclesByMakeModel(vehicleMake, vehicleModel);
        }
    }

    public void processGetByYearRequest() {
        promptInstructions("Enter vehicle year to search vehicles from:  " + dealership.getName());
        String vehicleYear = promptUser("Year: ");
        int year = Integer.parseInt(vehicleYear);

        String parsedYear = String.valueOf(year);

        //Checking length of String parsedYear is not greater than 4
        if (year != 0 && parsedYear.length() == 4) {
            dealership.getVehiclesByYear(year);
        } else {
            System.out.println("Invalid year. Please try again.");
        }
    }

    public void processGetByColorRequest() {
        promptInstructions("Enter vehicle color to search vehicles from:  " + dealership.getName());
        String vehicleColor = promptUser("Color: ");

        if (!vehicleColor.isEmpty()) {
            dealership.getVehiclesByColor(vehicleColor);
        }
    }

    public void processGetByMileageRequest() {
        promptInstructions("Enter your desired mileage range to search vehicles from:  " + dealership.getName());
        String vehicleOdometer = promptUser("Mileage: ");
        int parsedVehicleOdometer = Integer.parseInt(vehicleOdometer);

        if (parsedVehicleOdometer != 0) {
            dealership.getVehiclesByMileage(parsedVehicleOdometer);
        }
    }

    public void processGetByVehicleTypeRequest() {
        promptInstructions("Enter vehicle type to search vehicles from:  " + dealership.getName());
        String vehicleType = promptUser("Type: ");

        if (!vehicleType.isEmpty()) {
            dealership.getVehiclesByVehicleType(vehicleType);
        }
    }

    public void processGetAllVehiclesRequest() {
        promptInstructions("Inventory for:  " + dealership.getName());
        dealership.getAllVehicles();
    }

    public void processAddVehicleRequest() throws IOException {
        Vehicle v;
        promptInstructions("Enter new vehicle to add into:  " + dealership.getName());

        String usedVehicleVIN = promptUser("VIN: ");
        int parsedUsedVehicleVIN = Integer.parseInt(usedVehicleVIN);

        String usedVehicleYear = promptUser("Year: ");
        int parsedUsedVehicleYear = Integer.parseInt(usedVehicleYear);

        String usedVehicleMake = promptUser("Make: ");
        String usedVehicleModel = promptUser("Model: ");
        String usedVehicleType = promptUser("Type: ");
        String usedVehicleColor = promptUser("Color: ");

        String usedVehicleMileage = promptUser("Mileage: ");
        int parsedUsedVehicleMileage = Integer.parseInt(usedVehicleMileage);

        String usedVehiclePrice = promptUser("Price: ");
        double parsedUsedVehiclePrice = Double.parseDouble(usedVehiclePrice);

        v = new Vehicle(parsedUsedVehicleVIN, parsedUsedVehicleYear, usedVehicleMake, usedVehicleModel, usedVehicleType, usedVehicleColor, parsedUsedVehicleMileage, parsedUsedVehiclePrice);

        dealership.addVehicle(v);
        DealershipFileManager.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest() throws IOException {
        Vehicle v;
        promptInstructions("Enter desired vehicle you wish to remove from:  " + dealership.getName() + "inventory");
        String vehicleVin = promptUser("VIN: ");
        int parsedVehicleVin = Integer.parseInt(vehicleVin);

        v = new Vehicle(parsedVehicleVin);

        dealership.removeVehicle(v);
        DealershipFileManager.saveDealership(dealership);
    }

    //Retrieves user input from a prompt
    public String promptUser(String prompt) {
        System.out.print(ColorCodes.WHITE + prompt + ColorCodes.RESET);
        return userInput = inputSc.nextLine().trim();
    }

    public void promptInstructions(String prompt) {
        String[] textDetails = prompt.split(": ");
        System.out.println(ColorCodes.LIGHT_BLUE + textDetails[0] + ColorCodes.ORANGE_BOLD + ColorCodes.ITALIC + textDetails[1] + ColorCodes.RESET);
    }
}
