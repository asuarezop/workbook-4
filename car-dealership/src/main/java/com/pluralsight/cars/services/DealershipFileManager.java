package com.pluralsight.cars.services;

import com.pluralsight.cars.models.Dealership;
import com.pluralsight.cars.models.Vehicle;
import java.io.*;

public class DealershipFileManager {

    public static BufferedWriter getBufferedWriter(String filename) throws IOException {
        //Set fileWriter to append mode in order to prevent data from being overwritten
        BufferedWriter bufWriter = new BufferedWriter(new FileWriter(filename));
        return bufWriter;
    }

    //Initializing the BufferedReader
    public static BufferedReader openFileReader(String filename) throws FileNotFoundException {
        //Creating a new BufferedReader object to read file and initializing it to read contents from FileReader
        BufferedReader bufReader = new BufferedReader(new FileReader(filename));
        return bufReader;
    }

    //Retrieving a Dealership object, load and read inventory.csv
    public static Dealership getDealership(String filename) {
        Dealership d = new Dealership();
        Vehicle v;

        try {
            //Calling openFileReader method to initialize BufferedReader
            BufferedReader bufReader = openFileReader(filename);

            //Reading each line of input from fileContents
            String fileContents;

            while ((fileContents = bufReader.readLine()) != null) {
                String[] dealershipData = fileContents.split("\\|");

                if(fileContents.startsWith("D")) {

                    //Constructing a new Dealership object and passing in header data from inventory.csv
                    d.setName(dealershipData[0]);
                    d.setAddress(dealershipData[1]);
                    d.setPhone(dealershipData[2]);
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

                v = new Vehicle(vin, year, make, model, type, color, miles, price);

                //Adding each vehicle in inventory to Dealership ArrayList
                d.getInventory().add(v);
            }

            //Returning back Dealership object
            return d;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

