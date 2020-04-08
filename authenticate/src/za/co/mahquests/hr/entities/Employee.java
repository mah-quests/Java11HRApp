package za.co.mahquests.hr.entities;

import java.time.LocalDate;

public class Employee extends Person {
    private static int empIncrement = 201;
    private String employeeTitle;
    private String employeeeID = "EMP-";
    private String departmentName;
    private int numberOfLeaveDays = 21;
    private LocalDate dateJoined;
    private double salary;

    public Employee(String fullNames, String IDNumber, int age, String departmentName, double salary, LocalDate dateJoined) {
        super(fullNames, IDNumber, age);
        this.departmentName = departmentName;
        this.employeeeID = generateEMPNumber();
        this.salary = salary;
        this.dateJoined = dateJoined;

    }

    public String generateEMPNumber() {
        empIncrement += 1;
        return employeeeID + empIncrement;
    }

    public int takeLeave(int daysAppliedFor) {
        if (daysAppliedFor < numberOfLeaveDays) {
            numberOfLeaveDays -= daysAppliedFor;
        }
        return numberOfLeaveDays;
    }

    public String toString() {
        return super.toString() + "\n" +
                "Employee ID = " + employeeeID + ",\n" +
                "Department Name = " + departmentName + ",\n" +
                "Date Joined = " + dateJoined.toString() + ",\n" +
                "Salary = " + salary + ",\n" +
                "Leave days = " + numberOfLeaveDays + "\n" +
                '}';
    }

}
