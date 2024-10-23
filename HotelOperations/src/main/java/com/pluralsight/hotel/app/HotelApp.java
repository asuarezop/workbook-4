package com.pluralsight.hotel.app;

import com.pluralsight.hotel.models.Reservation;

public class HotelApp {
    public static void main(String[] args) {
        Reservation r = new Reservation("king", 3, true);

        System.out.printf("Total Price of Reservation: $%.2f", r.getReservationTotal());
    }
}
