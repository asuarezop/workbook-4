package com.pluralsight.hotel.app;

import com.pluralsight.hotel.models.Reservation;
import com.pluralsight.hotel.models.Room;

public class HotelApp {
    public static void main(String[] args) {
        Reservation r = new Reservation("king", 3, true);
        Room rm = new Room(2, 124.00, false, false, false);

        System.out.printf("Total Price of Reservation: $%.2f", r.getReservationTotal());
    }
}
