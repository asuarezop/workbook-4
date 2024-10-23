package com.pluralsight.hotel.models;

public class Room {
    private int numOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isClean;
    private boolean isAvailable;

    public Room(int numOfBeds, double price, boolean isOccupied, boolean isClean, boolean isAvailable) {
        this.numOfBeds = numOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isClean = isClean;
        this.isAvailable = isAvailable;
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isClean() {
        return isClean;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkIn() {
        this.isAvailable = false;
        this.isOccupied = true;
        this.isClean = false;

        System.out.println("Room is currently occupied.");
    }

    public void checkOut(Room r) {
        this.isOccupied = false;
        this.isAvailable = false;

        //Room needs to be cleaned before being made available
        cleanRoom(r);
    }

    public void cleanRoom(Room r) {
        if (!r.isClean) {
            this.isClean = true;
            this.isAvailable = true;
            System.out.println("Room is available!");
        }
    }
}
