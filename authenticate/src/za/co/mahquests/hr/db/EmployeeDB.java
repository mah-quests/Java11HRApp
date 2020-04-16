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

    public static int getNextArrayElement() {
        rowNumber = employeeDB.size();
        return rowNumber++;
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
        //line 62 - changed how the options appear
        System.out.print("\n [Save] [New] [Cancel] ");
        String result = in.next();

        if (result.equalsIgnoreCase("Save")) {
            employeeDB.add(getNextArrayElement(), new Employee(name, idNumber, age, departmentName, salary, dateOfEmployment));
            System.out.println(name + " successfully added in the employee database!\n\n\n");
            System.out.println("The company has : [ " + employeeDB.size() + " ]" + "number of employees");
            Model.clearScreen();
            Model.welcomeMessage();
        }
        else if (result.equalsIgnoreCase("New")) {
            employeeDB.add(getNextArrayElement(), new Employee(name, idNumber, age, departmentName, salary, dateOfEmployment));
            System.out.println(name + " successfully added in the employee database!\n\n\n");
            System.out.println("The company has : [ " + employeeDB.size() + " ]" + "number of employees");
            addUserForm();
        }
        else if (result.equalsIgnoreCase("Cancel")) {
            System.out.println("Employee not added to the database!");
            Model.clearScreen();
            Model.welcomeMessage();
        }
        else{
            addUserForm();
        }


    }
    public static void addEmployeeInDB(Person person) {
        employeeDB.add(person);
    }

    public static void showListOfUser() {
        Model.clearScreen();
        Model.listOfEmployees();

        if (employeeDB.size() > 0) {

            for (int count = 0; count < employeeDB.size(); count++) {
                Object person = employeeDB.get(count);
                System.out.println(count + ". " + ((Person) person).getFullNames());
            }
            System.out.println((employeeDB.size()) + ". Go Back");
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

        if (employeeDB.size() > 0) {
            Model.viewEmployeeDetail();

            System.out.println(employeeDB.get(choice));
        }

        Scanner in = new Scanner(System.in);

        System.out.print("\n[Back][Update][Exit] :");
        String goBack = in.next();

        if (goBack.equals("Back")) {
            Model.clearScreen();
            Model.welcomeMessage();
        } else if(goBack.equals("Update")) {

            updateEmployeeDetails(choice);
        }else if(goBack.equals("Exit")){
            System.exit(0);
        }

    }

    public static void updateEmployeeDetails(int choice) {

        Object employee = (Employee)employeeDB.get(choice);
        String fullNames = ((Employee) employee).getFullNames();

        Model.updateEmployeeDetail();

        Scanner in  = new Scanner(System.in);

        System.out.println("Current  First Name:      "  + ((Employee) employee).getFirstName());
        System.out.print("New First Name:      ");
        String fname = in.next();

        System.out.println("Current  Last Name: "  + ((Employee) employee).getLastName());
        System.out.print("Employee Last Name:    ");
        String lname = in.next();

        String name = fname + lname;

        System.out.print("Current Employee ID Number : " + ((Employee) employee).getIDNum());
        System.out.print("     Employee ID Number:   ");
        String idNumber = in.next();

        System.out.print("Current Employee Current Age : " + ((Employee) employee).getAge());
        System.out.print("    Employee Age:    ");
        int age = in.nextInt();

        System.out.print(" Current Employee Department : " + ((Employee) employee).getDepartmentName());
        System.out.print("    Employee Department:      ");
        String departmentName = in.next();

        System.out.print("Current Employee Salary : " + ((Employee) employee).getSalary());
        System.out.print("    Employee Salary:    ");
        double salary = in.nextDouble();

        System.out.println("Date of employment: " + ((Employee) employee).getDateJoined());
        System.out.print("       Please enter year of employment [eg, 2014]:    ");
        int year = in.nextInt();
        System.out.print("       Please enter month of employment [eg, 03]:     ");
        int month = in.nextInt();
        System.out.print("       Please enter day of employment [eg, 30]:         ");
        int day = in.nextInt();

        LocalDate dateOfEmployment = LocalDate.of(year, month, day);


        System.out.print("\n[Save] [Back] [Exit] ");
        String result = in.next();

        if (result.equalsIgnoreCase("Save")) {
            employeeDB.set(choice,new Employee(name ,idNumber, age, departmentName, salary, dateOfEmployment));
            System.out.println(fname +" " + lname + " successfully updated in the employee database!\n\n\n");
            System.out.println("The company has : [ " + employeeDB.size() + " ]" + "number of employees");

        } else if (result.equalsIgnoreCase("Back")) {
            System.out.println("Employee not added to the database!");
            Model.clearScreen();
            Model.welcomeMessage();
        } else if(result.equalsIgnoreCase("Exit")){
            System.exit(0);
        }

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

    public static boolean seachPattern(String searchString, String searchBy) {

        String patternString = ".*" + searchBy + ".*";

        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(searchString);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }

    }


    public static void searchByFirstName() {

        Scanner in = new Scanner(System.in);

        if (employeeDB.size() == 0) {

            System.out.println("There are no registered employees on the database");
            System.out.println("Please select an option");
            System.out.println("[Back] [Exit]");
            String choice = in.next();

            if(choice.equalsIgnoreCase("Back")) {
                Model.displayMenu("page3", " ");
            }
        } else {
            System.out.print("\nFirst name you want to search by : ");
            String firstName = in.nextLine();

            var tempDB = new ArrayList<>();

            for (Object list : employeeDB) {
                String fullname = ((Employee) list).getFirstName();
                if (seachPattern(fullname, firstName)) {
                    tempDB.add(list);
                }
            }

            for (int count = 0; count < tempDB.size(); count++) {
                Object person = tempDB.get(count);
                System.out.println(count + ". " + ((Employee) person).getFullNames());
                System.out.print("Please select an option to view [eg.1]");
                int choice = in.nextInt();
                getEmployeeDetails(choice);
            }
        }
       System.out.println("Please select an option");
        System.out.println("[Back] [Exit]");
        String choice = in.next();

        if (choice.equalsIgnoreCase("Back")) {
            Model.clearScreen();
            Model.displayMenu("page3", "");

        }

        if (choice.equalsIgnoreCase("Exit")) {
            System.exit(0);
        }


    }


    public static void searchByLastName() {

        Scanner in = new Scanner(System.in);

        if(employeeDB.size()==0){

            System.out.println("There are no registered employees on the database");
            System.out.println("Please select an option");
            System.out.println("[Back] [Exit]");
            String choice = in.next();

            if(choice.equalsIgnoreCase("Back")) {
                Model.displayMenu("page3", " ");
            }
        }
        else {
            System.out.print("\nLast name you want to search by : ");
            String lastName = in.nextLine();

            var tempDB = new ArrayList<>();

            for (Object list : employeeDB) {
                String fullname = ((Employee) list).getLastName();
                if (seachPattern(fullname, lastName)) {
                    tempDB.add(list);
                }
            }

            for (int count = 0; count < tempDB.size(); count++) {
                Object person = tempDB.get(count);
                System.out.println(count + ". " + ((Employee) person).getFullNames());
                System.out.print("Please select an option to view [eg.1]");
                int choice = in.nextInt();
                getEmployeeDetails(choice);
            }
        }
                System.out.println("Please select an option");
                System.out.println("[Back] [Exit]");
                String choice = in.next();

                if (choice.equalsIgnoreCase("Back")) {

                    Model.displayMenu("page3", "");
                }

                if (choice.equalsIgnoreCase("Exit")) {
                    System.exit(0);
                }


    }


    public static void searchByEmployeeNumber() {

        Scanner in = new Scanner(System.in);

        if(employeeDB.size() ==0){
            System.out.println("There are no registered employees on the database");
            System.out.println("Please select an option");
            System.out.println("[Back] [Exit]");
            String choice = in.next();

            if(choice.equalsIgnoreCase("Back")) {
                Model.displayMenu("page3", " ");
            }
        }

        else {
            System.out.print("\nEmployee ID you want to search by : ");
            String empId = in.next();

            var tempDB = new ArrayList<>();

            for (Object list : employeeDB) {
                String employeeID = ((Employee) list).getEmpId();
                if (seachPattern(employeeID, empId)){
                    tempDB.add(list);
                }
            }
            for (int count = 0; count < tempDB.size(); count++) {
                Object person = tempDB.get(count);
                System.out.println(count + ". " + ((Employee) person).getFullNames());
                System.out.print("Please select an option to view [eg.1]");
                int choice = in.nextInt();
                getEmployeeDetails(choice);
            }
        }
                System.out.println("Please select an option");
                System.out.println("[Back] [Exit]");
                String choice = in.next();

                if(choice.equalsIgnoreCase("Back")){
                    Model.clearScreen();
                    Model.displayMenu("page3","");
                }

                if(choice.equalsIgnoreCase("Exit")) {
                    System.exit(0);
                }

            }
        }