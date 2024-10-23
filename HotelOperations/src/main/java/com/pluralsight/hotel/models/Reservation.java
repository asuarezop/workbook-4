package com.pluralsight.hotel.models;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;
    private double price;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public double getPrice() {
        return price;
    }

    //Non-static method for Reservation
    public double getReservationTotal() {
        double totalPrice = 0.0;

        if (roomType.equals("king") && isWeekend) {
            double priceOnWeekend = (139.00 * 0.10) + 139.00;
            totalPrice = priceOnWeekend * getNumberOfNights();
        } else if (roomType.equals("double") && isWeekend) {
            double priceOnWeekend = (124.00 * 0.10) + 124.00;
            totalPrice = priceOnWeekend * getNumberOfNights();
        } else if (roomType.equals("king")) {
            totalPrice = 139.00 * getNumberOfNights();
        } else if (roomType.equals("double")) {
            totalPrice = 124.00 * getNumberOfNights();
        }

        return totalPrice;
    }
}
