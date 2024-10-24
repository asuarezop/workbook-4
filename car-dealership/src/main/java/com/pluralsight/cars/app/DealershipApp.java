package com.pluralsight.cars.app;

import com.pluralsight.cars.models.Dealership;
import com.pluralsight.cars.services.DealershipFileManager;
import com.pluralsight.cars.services.UserInterface;

import java.util.Scanner;

public class DealershipApp {
    static final String inventoryCSV = "src/main/resources/inventory.csv";

    //Instance variable (attribute) for UserInterface
    public static Dealership dealership;

    public static void main(String[] args) {

        init();
        System.out.println(dealership);
        UserInterface.showHomeScreen();
    }

    private static void init(){
       dealership = DealershipFileManager.getDealership(inventoryCSV);
    }


}
