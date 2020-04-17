package za.co.mahquests.hr.db;

import za.co.mahquests.decoration.Model;
import za.co.mahquests.hr.authenticate.LocalAuthDB;
import za.co.mahquests.hr.entities.Training;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static za.co.mahquests.decoration.Model.showMonthlyTrainingMenu;

public class TrainingDB {

    private static List trainingDB = new ArrayList<Training>();
    private static int rowNumber;


    public static int getNextArrayElement(){
        rowNumber = trainingDB.size();
        return  rowNumber++;


    }

    public static void trainingFunctionOption () {

        Scanner in = new Scanner(System.in);

        System.out.print("\nPlease select an option [eg. 1] : ");
        int choice = in.nextInt();

        if (choice == 1) {
            Model.addTrainingToMonthMenu();
            selectAddNewTraining();

        } else if (choice == 2) {

            Model.viewCompanyTraining();
            viewTraining(choice);

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

    public static void viewTraining (int choice) {

        Model.displayMenu("page6", LocalAuthDB.role);
        Scanner in = new Scanner(System.in);

        System.out.print("Select the month to view list of training : ");
        int month = in.nextInt();

        getMonthChoice(month, "view");
        displayTraining(month);

    }

    public static void deleteTraining () {

        Model.displayMenu("page6", LocalAuthDB.role);
        Scanner in = new Scanner(System.in);

        System.out.print("Select the month to delete Training : ");
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
                    deleteMonthTraining(1);

                    break;
                case 2:
                    deleteMonthTraining(2);

                    break;
                case 3:
                    deleteMonthTraining(3);

                    break;
                case 4:
                    deleteMonthTraining(4);

                    break;
                case 5:
                    deleteMonthTraining(5);

                    break;
                case 6:
                    deleteMonthTraining(6);

                    break;
                case 7:
                    deleteMonthTraining(7);

                    break;
                case 8:
                    deleteMonthTraining(8);

                    break;
                case 9:
                    deleteMonthTraining(9);

                    break;
                case 10:
                    deleteMonthTraining(10);

                    break;
                case 11:
                    deleteMonthTraining(11);

                    break;
                case 12:
                    deleteMonthTraining(12);

                    break;
                default:
                    System.out.println();
            }
        }
        else if (function.equals("update")){
            switch (input) {
                case 1:
                    updateTraining(1);

                    break;
                case 2:
                    updateTraining(2);

                    break;
                case 3:
                    updateTraining(3);

                    break;
                case 4:
                    updateTraining(4);

                    break;
                case 5:
                    updateTraining(5);

                    break;
                case 6:
                    updateTraining(6);

                    break;
                case 7:
                    updateTraining(7);

                    break;
                case 8:
                    updateTraining(8);

                    break;
                case 9:
                    updateTraining(9);

                    break;
                case 10:
                    updateTraining(10);

                    break;
                case 11:
                    updateTraining(11);

                    break;
                case 12:
                    updateTraining(12);

                    break;
                default:
                    System.out.println();
            }
        }
    }


    public static void displayTraining(int month){
        var tempDB = new ArrayList<>();

        LocalDate startDate = LocalDate.of(2020, month, 01);
        LocalDate endDate   = YearMonth.of(2020,month).atEndOfMonth();

        for (Object list : trainingDB) {
            LocalDate listedDate = ((Training) list).getEndDate();

            if(listedDate.isAfter(startDate) && listedDate.isBefore(endDate)) {
                tempDB.add(list);
            }

        }

        for (int count = 0; count < tempDB.size(); count++) {
            Object training = tempDB.get(count);
            System.out.println(((Training) training).getStartDate() + " - " + ((Training) training).getTrainingTitle());
        }
    }


    public static void addNewTraining (int month ) {

        Model.clearScreen();
        Model.addTrainingToMonthMenu();

        displayTraining(month);

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

        String nothing = in.nextLine();
        System.out.print("Course Title : ");
        String title = in.nextLine();


        System.out.print("\n [ Save ] [ New ] [ Back ] ");
        String result = in.nextLine();

        if (result.equalsIgnoreCase("Save") && startDate.isBefore(endDate)) {
            trainingDB.add(getNextArrayElement(), new Training(startDate,endDate,title));
            System.out.println(title + " successfully added in the training database!");
            System.out.println("The company has : [ " + trainingDB.size() +" ]" + "number of training this month");
            showMonthlyTrainingMenu();
            Model.displayMenu("page5", LocalAuthDB.role);
            trainingFunctionOption();
        }
        else if (result.equalsIgnoreCase("New") && startDate.isBefore(endDate))
        {
            trainingDB.add(getNextArrayElement(), new Training(startDate,endDate,title));
            System.out.print(title + " successfully added in the training database!");
            System.out.println("Now adding a another new training");
            showMonthlyTrainingMenu();
            selectAddNewTraining();
        }

        else if (result.equalsIgnoreCase("Back"))
        {
            System.out.print("Entry not saved in the database... ");
            showMonthlyTrainingMenu();
            Model.displayMenu("page5", LocalAuthDB.role);
            TrainingDB.trainingFunctionOption();
        }
        else
        {
            showMonthlyTrainingMenu();
            Model.displayMenu("page5", LocalAuthDB.role);
            TrainingDB.trainingFunctionOption();
        }

        Model.clearScreen();
        Model.welcomeMessage();

    }


    public static String deleteMonthTraining(int month){

        Model.clearScreen();
        int count = 0;
        if (trainingDB.size() > 0) {       //View all the announcement to choose one to delete;
            for (count = 0; count < trainingDB.size(); count++) {
                Object training = trainingDB.get(count);
                System.out.println(((Training) training).getStartDate() + " - " + ((Training) training).getTrainingTitle());
            }

            Scanner in = new Scanner(System.in);

            System.out.print("\nDelete by Training ID  or -1 to Go back: ");
            int choice = in.nextInt();
            if (choice == -1) {
                Model.listCompanyAnnouncementsMenu();
                Model.displayMenu("page4", LocalAuthDB.role);
                MessagesDB.companyAnnouncementsOption();
            }
            trainingDB.remove(choice);

            System.out.println("Announcement deleted");
            Model.deleteCompanyTraining();
            deleteTraining();

        } else {
            System.out.println("No training scheduled this month. press 99 to Add new training");
            Scanner myReader = new Scanner(System.in);
            int choice = myReader.nextInt();
            if (choice == 99) {
                selectAddNewTraining();       //back to add new Training
            }
        }
        return "deleteCompanyTraining()";
    }





    public static void updateTraining (int month){

        Model.clearScreen();
        Model.updateCompanyTraining();

        displayTraining(month);

        Scanner in = new Scanner(System.in);

        System.out.print("\n [ Back ] [ Exit ] ");
        String result = in.nextLine();

        if (result.equalsIgnoreCase("Back")) {
            showMonthlyTrainingMenu();
            Model.displayMenu("page5", LocalAuthDB.role);
            TrainingDB.trainingFunctionOption();
        } else if (result.equalsIgnoreCase("Exit")) {
            System.exit(0);
        }

    }
}




