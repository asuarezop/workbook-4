package com.pluralsight.hotel.app;

import com.pluralsight.hotel.models.Employee;
import com.pluralsight.hotel.models.Reservation;
import com.pluralsight.hotel.models.Room;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HotelApp {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
        String startTime = time.format(fmt);

        Reservation r = new Reservation("king", 3, true);
        Room rm = new Room(2, 124.00, false, false, false);

        Employee e = new Employee(1, "Bob", "Maintenance", 21.00, 30);

        //Employee punching in
        e.punchIn(startTime);

        System.out.printf("Total Price of Reservation: $%.2f", r.getReservationTotal());
    }
}
