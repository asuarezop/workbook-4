package com.pluralsight.cars.services;

import com.pluralsight.cars.models.Dealership;

public class UserInterface {
    public static final String inventoryCSV = "src/main/resource/inventory.csv";

    //Instance variable (attribute) for UserInterface
    private Dealership dealership;

    public UserInterface(Dealership d) {
        this.dealership = d;
    }

    private Dealership retrieveDealership() {
        dealership = DealershipFileManager.getDealership(inventoryCSV);

        return dealership;
    }



    public static void showUI() {
//        retrieveDealership();
    }
}
