package com.pluralsight.hotel.models;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    public Employee(int employeeId, String name, String department, double payRate, int hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    //Non-static methods for Employee
    public double getTotalPay() {
        return getPayRate() * getHoursWorked();
    }

    public double getRegularHours() {
        return 0;
    }

    public double getOvertimeHours() {
        return 0;
    }

    public void punchIn(double startTime) {
        //Getting the hours and minutes from narrow casting (double to int)
        int hours = (int) startTime;
        int minutes = (int) ((startTime - hours) * 60);

        //Using LocalTime to construct a new time out of above variables
        LocalTime time = LocalTime.of(hours, minutes);
        String formattedTime = time.format(DateTimeFormatter.ofPattern("HH:mm"));

        //Conditionally rendering formattedTime to specify if employee started work in the morning or in the afternoon
        System.out.println("Clocked in at: " + (time.isBefore(LocalTime.of(12, 0)) ? formattedTime + " am" : formattedTime + " pm"));
    }

    public void punchOut(double endTime) {
        //Getting the hours and minutes from narrow casting (double to int)
        int hours = (int) endTime;
        int minutes = (int) ((endTime - hours) * 60);

        //Using LocalTime to construct a new time out of above variables
        LocalTime time = LocalTime.of(hours, minutes);
        String formattedTime = time.format(DateTimeFormatter.ofPattern("HH:mm"));

        //Conditionally rendering formattedTime to specify if employee ended work in the morning or in the afternoon
        System.out.println("Clocked out at: " + (time.isBefore(LocalTime.of(12, 0)) ? formattedTime + " am" : formattedTime + " pm"));
    }
}
