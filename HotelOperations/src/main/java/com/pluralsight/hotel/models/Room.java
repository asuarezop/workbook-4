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
}
