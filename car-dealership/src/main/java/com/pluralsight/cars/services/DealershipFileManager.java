package com.pluralsight.cars.services;

import com.pluralsight.cars.models.Dealership;
import com.pluralsight.cars.models.Vehicle;

import java.io.*;
import java.util.ArrayList;

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
        Dealership d = null;
        Vehicle v;

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try {
            //Calling openFileReader method to initialize BufferedReader
            BufferedReader bufReader = openFileReader(filename);

            //Reading each line of input from fileContents
            String fileContents;

//            //Skip the first line of file
//            bufReader.readLine();

            while ((fileContents = bufReader.readLine()) != null) {
                String[] dealershipData = fileContents.split("\\|");

                //Constructing a new Dealership object and passing in header data from inventory.csv
                d = new Dealership(dealershipData[0], dealershipData[1], dealershipData[2]);

                //Passing in vehicle data into new ArrayList of vehicles
                int vin = Integer.parseInt(dealershipData[3]);
                int year = Integer.parseInt(dealershipData[4]);
                String make = dealershipData[5];
                String model = dealershipData[6];
                String type = dealershipData[7];
                String color = dealershipData[8];
                int miles = Integer.parseInt(dealershipData[9]);
                double price = Double.parseDouble(dealershipData[10]);

                v = new Vehicle(vin, year, make, model, type, color, miles, price);

                //Adding each vehicle in inventory to vehicles ArrayList
                vehicles.add(v);
            }

            return d;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

