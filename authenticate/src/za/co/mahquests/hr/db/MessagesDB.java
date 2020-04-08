package za.co.mahquests.hr.db;

import za.co.mahquests.decoration.Model;

import java.util.Scanner;

public class MessagesDB {
    // Hardcoded, needs proper implementation
    public static void companyAnnouncementsOption() {

        Scanner in = new Scanner(System.in);

        System.out.print("\nPlease select an option [eg. 1] : ");
        int choice = in.nextInt();

        if (choice == 1) {
            Model.addCompanyAnnouncements();
            addNewAnnouncement();

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
    public static String addNewAnnouncement() {

        System.out.println("\n***** Functionality for showing a list of users *****");
        System.out.println("***** Currently hard-coded *****");
        System.out.println("***** Functionality to be implemented here *****");

        Scanner in = new Scanner(System.in);

        System.out.print("\nSubject of your new announcement : ");
        String subject = in.next();

        System.out.print("\nDetail of the announcements : ");
        String detail = in.next();

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
