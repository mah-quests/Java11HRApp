package za.co.mahquests.hr.db;

import za.co.mahquests.decoration.Model;
import za.co.mahquests.hr.authenticate.LocalAuthDB;
import za.co.mahquests.hr.entities.Employee;
import za.co.mahquests.hr.entities.Person;
import za.co.mahquests.hr.entities.Training;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainingDB {

    private static List trainingDB = new ArrayList<Training>();
    private static int rowNumber;


    public static int getNextArrayElement(){
        rowNumber = trainingDB.size();
        return  rowNumber++;


    }

    // Hardcoded, needs proper implementation

    public static void trainingFunctionOption () {

        Scanner in = new Scanner(System.in);

        System.out.print("\nPlease select an option [eg. 1] : ");
        int choice = in.nextInt();

        if (choice == 1) {
            Model.addTrainingToMonthMenu();
            selectAddNewTraining();

        } else if (choice == 2) {

            Model.viewCompanyTraining();
           viewTraining();

        } else if (choice == 3) {

            Model.deleteCompanyTraining();
            deleteTraining();

        } else {
            return;
        }

    }


    public static void selectAddNewTraining () {

        Model.displayMenu("page6", LocalAuthDB.role);
        Scanner in = new Scanner(System.in);

        System.out.print("Select the month to add Training : ");
        int month = in.nextInt();

        getMonthChoice(month, "add");


    }

    public static void selectDeleteTraining() {

        Model.displayMenu("page6", LocalAuthDB.role);
        Scanner in = new Scanner(System.in);

        System.out.print("Select the month to Delete Training : ");
        int month = in.nextInt();

        getMonthChoice(month, "delete");

    }

    public static void selectUpdateTraining() {

        Model.displayMenu("page6", LocalAuthDB.role);
        Scanner in = new Scanner(System.in);

        System.out.print("\nSelect the month to Update Training : ");
        int month = in.nextInt();

        getMonthChoice(month, "update");
    }

    public static void getMonthChoice(int input, String function) {
        if (function.equals("add")) {
            switch (input) {
                case 1:
                    addNewTraining(1);

                    break;
                case 2:
                    addNewTraining(2);

                    break;
                case 3:
                    addNewTraining(3);

                    break;
                case 4:
                    addNewTraining(4);

                    break;
                case 5:
                    addNewTraining(5);

                    break;
                case 6:
                    addNewTraining(6);

                    break;
                case 7:
                    addNewTraining(7);

                    break;
                case 8:
                    addNewTraining(8);

                    break;
                case 9:
                    addNewTraining(9);

                    break;
                case 10:
                    addNewTraining(10);

                    break;
                case 11:
                    addNewTraining(11);

                    break;
                case 12:
                    addNewTraining(12);

                    break;
                default:
                    System.out.println();
            }

        }else if (function.equals("delete")){
            switch (input) {
                case 1:
                    deleteTraining();

                    break;
                case 2:
                    System.out.println("February");
                    deleteTraining();

                    break;
                case 3:
                    System.out.println("March");
                    deleteTraining();

                    break;
                case 4:
                    System.out.println("April");
                    deleteTraining();

                    break;
                case 5:
                    System.out.println("May");
                    deleteTraining();

                    break;
                case 6:
                    System.out.println("June");
                    deleteTraining();

                    break;
                case 7:
                    System.out.println("July");
                    deleteTraining();

                    break;
                case 8:
                    System.out.println("August");
                    deleteTraining();

                    break;
                case 9:
                    System.out.println("September");
                    deleteTraining();

                    break;
                case 10:
                    System.out.println("October");
                    deleteTraining();

                    break;
                case 11:
                    System.out.println("November");
                    deleteTraining();

                    break;
                case 12:
                    System.out.println("December");
                    deleteTraining();

                    break;
                default:
                    System.out.println();
            }
        }
        else if (function.equals("update")){
            switch (input) {
                case 1:
                    System.out.println("January");
                    updateTraining();

                    break;
                case 2:
                    System.out.println("February");
                    updateTraining();

                    break;
                case 3:
                    System.out.println("March");
                    updateTraining();

                    break;
                case 4:
                    System.out.println("April");
                    updateTraining();

                    break;
                case 5:
                    System.out.println("May");
                    updateTraining();

                    break;
                case 6:
                    System.out.println("June");
                    updateTraining();

                    break;
                case 7:
                    System.out.println("July");
                    updateTraining();

                    break;
                case 8:
                    System.out.println("August");
                    updateTraining();

                    break;
                case 9:
                    System.out.println("September");
                    updateTraining();

                    break;
                case 10:
                    System.out.println("October");
                    updateTraining();

                    break;
                case 11:
                    System.out.println("November");
                    updateTraining();

                    break;
                case 12:
                    System.out.println("December");
                    updateTraining();

                    break;
                default:
                    System.out.println();
            }
        }



    }

    public static void addNewTraining (int month ) {

        Model.clearScreen();
        Model.addTrainingToMonthMenu();

        Scanner in = new Scanner(System.in);

        System.out.println("Start Date of Training: ");
        System.out.print("       Please enter year of training [eg, 2020]: ");
        int starYear = in.nextInt();
        System.out.print("       The month selected is :  " + month);
        System.out.print(" ");
        System.out.print( "\n       Please enter day of training [eg, 30]: ");
        int startDay = in.nextInt();
        LocalDate startDate = LocalDate.of(starYear, month, startDay);

        System.out.print("End Date of Training: ");
        System.out.print("\n       Please enter year of training [eg, 2020]: ");
        int endYear = in.nextInt();
        System.out.print("       Please enter month of training [eg, 03]: ");
        int endMonth = in.nextInt();
        System.out.print("       Please enter day of training [eg, 30]: ");
        int endDay = in.nextInt();
        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);

        System.out.print("Course Title : ");
        String title = in.next();


        System.out.print("\n [ Save ] [ Update ] [ Back ] ");
        String result = in.next();

        if (result.equalsIgnoreCase("Save") && startDate.isBefore(endDate)) {
            trainingDB.add(getNextArrayElement(), new Training(startDate,endDate,title));
            System.out.println(title + " successfully added in the training database!\n\n\n");
            System.out.println("The company has : [ " + trainingDB.size() +" ]" + "number of training this month");
        }
        else if (result.equalsIgnoreCase("Update"))
        {

            System.out.println(" Still need to create update method");
        }

        else if (result.equalsIgnoreCase("Back"))
        {

            Model.showMonthlyTrainingMenu();
            Model.displayMenu("page5", LocalAuthDB.role);
            TrainingDB.trainingFunctionOption();
        }
        else
        {
            System.out.println("Training not added");
        }

        Model.clearScreen();
        Model.welcomeMessage();

    }

    public static void deleteTraining () {

        Model.clearScreen();
        Model.deleteCompanyTraining();

        Scanner in = new Scanner(System.in);

        System.out.println("Start Date of Training: ");
        System.out.print("       Please enter year of training you want to delete[eg, 2020]: ");
        int starYear = in.nextInt();
        System.out.print("       Please enter month of training you want to delete [eg, 03]: ");
        int startMonth = in.nextInt();
        System.out.print("       Please enter day of training you want to delete [eg, 30]: ");
        int startDay = in.nextInt();
        LocalDate startDate = LocalDate.of(starYear, startMonth, startDay);

        System.out.println("End Date of Training you want to delete: ");
        System.out.print("       Please enter year of training you want to delete[eg, 2020]: ");
        int endYear = in.nextInt();
        System.out.print("       Please enter month of training you want to delete[eg, 03]: ");
        int endMonth = in.nextInt();
        System.out.print("       Please enter day of training you want to delete [eg, 30]: ");
        int endDay = in.nextInt();
        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);

        System.out.print("Delete Course Title : ");
        String title = in.next();


        System.out.print("\nTraining Details loaded, type  \'Delete\' to Delete: ");
        String result = in.next();

        if (result.equalsIgnoreCase("Delete")) {
            //trainingDB.remove(getNextArrayElement(), new Training(startDate,endDate,title));
            trainingDB.remove(getNextArrayElement());
            System.out.println(title + " successfully Deleted from the training database!\n\n\n");
            System.out.println("The company has : [ " + trainingDB.size() +" ]" + "number of training this month");
        }

        trainingDB.forEach(s-> System.out.println(s));

        Model.clearScreen();
        Model.welcomeMessage();

    }

    public static void updateTraining () {

        Model.clearScreen();
        Model.updateCompanyTraining();

        Scanner in = new Scanner(System.in);

        System.out.println("Start Date of Training: ");
        System.out.print("       Please enter year of training you want to Update [eg, 2020]: ");
        int starYear = in.nextInt();
        System.out.print("       Please enter the updated training year [eg, 2020]: ");
        int updatedStartYear = in.nextInt();
        System.out.print("       Please enter month of training you want to update [eg, 03]: ");
        int startMonth = in.nextInt();
        System.out.print("       Please enter the updated training Month [eg, 03]: ");
        int updatedStartMonth = in.nextInt();
        System.out.print("       Please enter day of training you want to update [eg, 30]: ");
        int startDay = in.nextInt();
        System.out.print("       Please enter the updated training day [eg, 30]: ");
        int updatedStartDay = in.nextInt();
        LocalDate UpdatedStartDate = LocalDate.of(updatedStartYear, updatedStartMonth, updatedStartDay);

        System.out.println("End Date of Training: ");
        System.out.print("       Please enter year of training you want to update[eg, 2020]: ");
        int endYear = in.nextInt();
        System.out.print("       Please enter the updated training year [eg, 2020]: ");
        int updatedEndYear = in.nextInt();
        System.out.print("       Please enter month of training you want to update [eg, 03]: ");
        int endMonth = in.nextInt();
        System.out.print("       Please enter month of training you want to update [eg, 03]: ");
        int updatedEndMonth = in.nextInt();
        System.out.print("       Please enter day of training you want to update [eg, 30]: ");
        int endDay = in.nextInt();
        System.out.print("       Please enter the updated training day [eg, 30]: ");
        int updatedEndDay = in.nextInt();
        LocalDate UpdatedEndDate = LocalDate.of(updatedEndYear, updatedEndMonth, updatedEndDay);

        System.out.print("update Course Title : ");
        String title = in.next();




        System.out.print("\nTraining Details loaded, type  \'Save\' to save: ");
        String result = in.next();

        if (result.equalsIgnoreCase("Save")) {
            trainingDB.add(getNextArrayElement(), new Training(UpdatedStartDate,UpdatedEndDate,title));
            System.out.println(title + " successfully Updated in the training database!\n\n\n");
            System.out.println("The company has : [ " + trainingDB.size() +" ]" + "number of training this month");
        }



        trainingDB.forEach(s-> System.out.println(s));

        Model.clearScreen();
        Model.welcomeMessage();

    }
    //just added

    public static void viewTraining () {

        int listSize = trainingDB.size();

        if (trainingDB.size()>0) {
            Model.viewCompanyTraining();

        }

        for (int i = 0; i<listSize; i++){
            System.out.println("The company has : [ " + trainingDB.size() +" ]" + "number of training this month");
        }


        Scanner in = new Scanner(System.in);

        System.out.print("\nEnter 0 to go back to main menu [eg. 0] : ");
        int goBack = in.nextInt();

        Model.clearScreen();
        Model.welcomeMessage();
    }


}

