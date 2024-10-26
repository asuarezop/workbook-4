package com.pluralsight.cars.services;
import com.pluralsight.cars.models.Dealership;
import com.pluralsight.cars.models.Vehicle;
import java.io.*;

public class DealershipFileManager {
    //Initializing the BufferedWriter
    public static BufferedWriter getBufferedWriter(String filename) throws IOException {
        BufferedWriter bufWriter = new BufferedWriter(new FileWriter(filename));
        return bufWriter;
    }

    //Initializing the BufferedReader
    public static BufferedReader openFileReader(String filename) throws FileNotFoundException {
        BufferedReader bufReader = new BufferedReader(new FileReader(filename));
        return bufReader;
    }

    //Retrieving a Dealership object, load and read from inventory.csv
    public static Dealership getDealership() {
        Dealership d = null;
        Vehicle v;

        try {
            //Calling openFileReader method to initialize BufferedReader
            BufferedReader bufReader = openFileReader(UserInterface.inventoryCSV);

            //Reading each line of input from fileContents
            String fileContents;

            while ((fileContents = bufReader.readLine()) != null) {
                String[] dealershipData = fileContents.split("\\|");

                if(fileContents.startsWith("D")) {
                    //Constructing a new Dealership object and passing in header data from inventory.csv
                    d = new Dealership(dealershipData[0], dealershipData[1], dealershipData[2]);
                    continue;
                }

                //Passing in vehicle data into new ArrayList of vehicles
                int vin = Integer.parseInt(dealershipData[0]);
                int year = Integer.parseInt(dealershipData[1]);
                String make = dealershipData[2];
                String model = dealershipData[3];
                String type = dealershipData[4];
                String color = dealershipData[5];
                int miles = Integer.parseInt(dealershipData[6]);
                double price = Double.parseDouble(dealershipData[7]);

                //Creating a new vehicle object, passing vehicle variables to constructor
                v = new Vehicle(vin, year, make, model, type, color, miles, price);

                //Adding each vehicle to inventory ArrayList
                d.getInventory().add(v);
            }
            bufReader.close();

            //Returning back Dealership object
            return d;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveDealership(Dealership d) throws IOException {
        try {
            BufferedWriter bufWriter = getBufferedWriter(UserInterface.inventoryCSV);

            //Writing dealership header to csv file
            bufWriter.write(d.getName() + "|" + d.getAddress() + "|" + d.getPhone() + "\n");

            //Writing all vehicles from dealership inventory to csv file
            for (Vehicle v: d.getInventory()) {
                bufWriter.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" + v.getVehicleType() + "|" + v.getColor() + "|" + v.getOdometer() + "|");
                bufWriter.write(String.format("%.2f \n", v.getPrice()));
            }

            bufWriter.close();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}

