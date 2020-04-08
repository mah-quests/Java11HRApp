package za.co.mahquests.hr.db;

import za.co.mahquests.decoration.Model;
import za.co.mahquests.hr.entities.Employee;
import za.co.mahquests.hr.entities.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeDB {
    private static List employeeDB = new ArrayList<Person>();
    private static int rowNumber;

    private EmployeeDB() {
    }

    public static int getNextArrayElement(){
        rowNumber = employeeDB.size();
        return  rowNumber++;
    }

    public static void addUserForm() {

        Model.clearScreen();
        Model.addUserForm();
        Scanner in = new Scanner(System.in);

        System.out.print("Employee First Name : ");
        String fname = in.next();

        System.out.print("Employee Last Name : ");
        String lname = in.next();

        String name = fname + " " + lname;

        System.out.print("Employee ID Number : ");
        String idNumber = in.next();

        System.out.print("Employee Current Age : ");
        int age = in.nextInt();

        System.out.print("Employee Department : ");
        String departmentName = in.next();

        System.out.print("Employee Salary : ");
        double salary = in.nextDouble();

        System.out.println("Date of employment: ");
        System.out.print("       Please enter year of employment [eg, 2014]: ");
        int year = in.nextInt();
        System.out.print("       Please enter month of employment [eg, 03]: ");
        int month = in.nextInt();
        System.out.print("       Please enter day of employment [eg, 30]: ");
        int day = in.nextInt();

        LocalDate dateOfEmployment = LocalDate.of(year, month, day);

        System.out.print("\nEmployee Details loaded, type  \'Save\' to save OR \'Cancel\' to cancel: ");
        String result = in.next();

        if (result.equalsIgnoreCase("Save")) {
            employeeDB.add(getNextArrayElement(), new Employee(name, idNumber, age, departmentName, salary, dateOfEmployment));
            System.out.println(name + " successfully added in the employee database!\n\n\n");
            System.out.println("The company has : [ " + employeeDB.size() +" ]" + "number of employees");
            addUserForm();
        }
        else if (result.equalsIgnoreCase("Cancel")) {
            System.out.println("Employee not added to the database!");
            Model.clearScreen();
            Model.welcomeMessage();
        }


    }

    public static void addEmployeeInDB(Person person) {
        employeeDB.add(person);
    }

    public static void showListOfUser() {
        Model.clearScreen();
        Model.listOfEmployees();

        if (employeeDB.size() > 0) {

            for (int count = 0; count < employeeDB.size(); count++){
                Object person = employeeDB.get(count);
                System.out.println(count + ". " + ((Person)person).getFullNames());
            }
            System.out.println((employeeDB.size() )+ ". Go Back");
        } else {
            System.out.println("No employees registered.");
            System.out.println("0. Go Back");
        }

        Scanner in = new Scanner(System.in);

        System.out.print("\nPlease select an option [eg. 1] : ");
        int choice = in.nextInt();
        getEmployeeDetails(choice);

    }

    public static void getEmployeeDetails(int choice) {

        if (employeeDB.size()>0) {//
            Model.viewEmployeeDetail();

            System.out.println(employeeDB.get(choice));
        }

        Scanner in = new Scanner(System.in);

        System.out.print("\nEnter 0 to go back to main menu or 'update' to edit employee information[eg. 0] : ");
        String goBack = in.next();

        if (goBack.equals("0")){
            Model.clearScreen();
            Model.welcomeMessage();
        }else
        {
            System.out.println("=======Employee Information to Update======"); //Testing else
            updateEmployeeDetails(choice);
        }

    }

    public static void updateEmployeeDetails(int choice) {

        System.out.println(employeeDB.get(choice));

        Scanner in = new Scanner(System.in);
        addUserForm();

    }


    public static void searchFunction() {

        Scanner in = new Scanner(System.in);

        System.out.print("\nPlease select an option [eg. 1] : ");
        int choice = in.nextInt();

        if (choice == 1) {
            Model.searchEmployeeByFirstName();
            searchByFirstName();

        } else if (choice == 2) {

            Model.searchEmployeeByLastName();
            searchByLastName();

        } else if (choice == 3) {

            Model.searchEmployeeByEmpID();
            searchByEmployeeNumber();

        } else {
            return;
        }

    }

    public static boolean seachPattern(String searchString, String searchBy){

        String patternString = ".*"+searchBy+".*";

        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(searchString);

        if(matcher.matches()){
            return true;
        } else {
            return false;
        }

    }


    public static void searchByFirstName() {

        Scanner in = new Scanner(System.in);

        System.out.print("\nFirst name you want to search by : ");
        String firstName = in.next();

        for(Object p : employeeDB){
            String fullname = ((Employee)p).getFullNames();
            if(seachPattern(fullname,firstName)){
                System.out.println(fullname);
            }

        }

    }


    // Hardcoded, needs proper implementation
    public static String searchByLastName() {

        System.out.println("\n***** Functionality for showing a list of users *****");
        System.out.println("***** Currently hard-coded *****");
        System.out.println("***** Functionality to be implemented here *****");

        Scanner in = new Scanner(System.in);

        System.out.print("\nLast name you want to search by : ");
        String choice = in.next();

//        getEmployeeDetails();

        return "searchByLasttName()";
    }

    // Hardcoded, needs proper implementation
    public static String searchByEmployeeNumber() {
        System.out.println("\n***** Functionality for showing a list of users *****");
        System.out.println("***** Currently hard-coded *****");
        System.out.println("***** Functionality to be implemented here *****");

        Scanner in = new Scanner(System.in);

        System.out.print("\nEmployee ID you want to search by : ");
        String choice = in.next();

//        getEmployeeDetails();

        return "searchByEmployeeNumber()";
    }


}
