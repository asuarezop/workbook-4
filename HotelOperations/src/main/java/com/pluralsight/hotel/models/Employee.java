package com.pluralsight.hotel.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

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

    public void punchIn(String time) {
        System.out.println("Clocked in at: " + time);
    }

    public void punchOut(String time) {
        System.out.println("Clocked out at: " + time);
    }
}
