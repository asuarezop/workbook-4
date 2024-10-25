package com.pluralsight.cars.app;

import com.pluralsight.cars.models.Dealership;
import com.pluralsight.cars.services.DealershipFileManager;
import com.pluralsight.cars.services.UserInterface;

public class DealershipApp {
    //String variable to hold inventory CSV file path
    static final String inventoryCSV = "src/main/resources/inventory.csv";

    //Local variable to hold a dealership
    public static Dealership dealership;

    public static void main(String[] args) {
        //Calling initialization method for program
        init();

        //Instantiating a new UserInterface object and passing dealership object to constructor
        UserInterface ui = new UserInterface(dealership);

        //Calling UserInterface display() for HomeScreen
        ui.showHomeScreen();
    }

    //init(): This method gets called first before any other methods are run inside main()
    private static void init(){
        //To get a new dealership object based on given csv file, storing it inside local variable of type Dealership
       dealership = DealershipFileManager.getDealership(inventoryCSV);
    }
}
