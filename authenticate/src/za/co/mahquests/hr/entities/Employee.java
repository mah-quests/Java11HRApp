package za.co.mahquests.hr.entities;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;
import java.util.regex.Pattern;

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


    public String getEmpId(){

        return employeeeID;
    }

    public String getSalary(){

        Locale locale = new Locale("en", "ZA");
        NumberFormat zaFormat = NumberFormat.getCurrencyInstance(locale);

        return  zaFormat.format(salary);

    }


    public int takeLeave(int daysAppliedFor) {
        if (daysAppliedFor < numberOfLeaveDays) {
            numberOfLeaveDays -= daysAppliedFor;
        }
        return numberOfLeaveDays;
    }

    public String toString() {
        return super.toString() + "\n" +
                "    Employee ID = " + employeeeID + ",\n" +
                "    Department Name = " + departmentName + ",\n" +
                "    Date Joined = " + dateJoined.toString() + ",\n" +
                "    Salary = " + getSalary() + ",\n" +
                "    Leave days = " + numberOfLeaveDays + "\n" +
                "}";
    }


    public String getFirstName(){

        String fullNames = getFullNames();
        String firstName = fullNames.substring(0,fullNames.lastIndexOf(" "));

        return firstName;
    }

    public String getLastName(){

        String fullNames = getFullNames();
        String[] split = fullNames.split( Pattern.quote(" " ) );
        String lastName = split[split.length-1];

        return lastName;
    }


}
