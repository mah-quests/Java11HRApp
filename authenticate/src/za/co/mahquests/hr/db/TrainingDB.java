package za.co.mahquests.hr.db;

import za.co.mahquests.decoration.Model;
import za.co.mahquests.hr.authenticate.LocalAuthDB;

import java.util.Scanner;

public class TrainingDB {
    // Hardcoded, needs proper implementation
    public static void trainingFunctionOption() {

        Scanner in = new Scanner(System.in);

        System.out.print("\nPlease select an option [eg. 1] : ");
        int choice = in.nextInt();

        if (choice == 1) {
            Model.addTrainingToMonthMenu();
            Model.displayMenu("page6", LocalAuthDB.role);
            addNewTraining();

        } else if (choice == 2) {

            Model.readCompanyAnnouncement();
            viewCompanyAnnouncements();

        } else if (choice == 3) {

            Model.deleteCompanyAnnouncement();
            deleteCompanyAnnouncement();

        } else {
            return;
        }

    }

    // Hardcoded, needs proper implementation
    public static String addNewTraining() {

        System.out.println("\n***** Functionality for adding training *****");
        System.out.println("***** Currently hard-coded *****");
        System.out.println("***** Functionality to be implemented here *****");

        Scanner in = new Scanner(System.in);

        System.out.print("\nSelect the month to add training : ");
        int month = in.nextInt();

        return "addNewAnnouncement()";
    }

    // Hardcoded, needs proper implementation
    public static String viewCompanyAnnouncements() {

        System.out.println("\n***** Functionality for showing a list of users *****");
        System.out.println("***** Currently hard-coded *****");
        System.out.println("***** Functionality to be implemented here *****");

        Scanner in = new Scanner(System.in);

        System.out.print("\nAnnouncement ID to read : ");
        String choice = in.next();


        return "viewCompanyAnnouncements()";
    }

    // Hardcoded, needs proper implementation
    public static String deleteCompanyAnnouncement() {
        System.out.println("\n***** Functionality for showing a list of users *****");
        System.out.println("***** Currently hard-coded *****");
        System.out.println("***** Functionality to be implemented here *****");

        Scanner in = new Scanner(System.in);

        System.out.print("\nDelete by Announcement ID : ");
        String choice = in.next();

        return "deleteCompanyAnnouncement()";
    }
}
