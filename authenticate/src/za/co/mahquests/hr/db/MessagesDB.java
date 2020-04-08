package za.co.mahquests.hr.db;

import za.co.mahquests.decoration.Model;
import za.co.mahquests.hr.authenticate.LocalAuthDB;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessagesDB {
    private static List<MessagesDB> messagesDBS = new ArrayList<MessagesDB>();
    private static int numOfRows;
    private String msgSubject;
    private String msgDetails;

    private MessagesDB() {

    }

    public MessagesDB(String msgSubject, String msgDetails) {
        this.msgSubject = msgSubject;
        this.msgDetails = msgDetails;
    }

    public String getMsgSubject() {
        return msgSubject;
    }

    public String getMsgDetails() {
        return msgDetails;
    }

    public static int getNextArrElemnt() {
        numOfRows = messagesDBS.size();
        return numOfRows++;
    }

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

        } else if (choice == 4) {
            Model.displayMenu("page1", LocalAuthDB.role);
        } else {
            System.out.println("!!!  Invalid Option  !!!. Please Re-Enter: \n");
            Model.displayMenu("page4", LocalAuthDB.role);
            MessagesDB.companyAnnouncementsOption();

        }

    }


    public static String addNewAnnouncement() {

        Model.clearScreen();
        Scanner in = new Scanner(System.in);
        System.out.println("Add an announcement \n====================");
        System.out.print("\nSubject of your new announcement : ");
        String subject = in.nextLine();

        System.out.print("\nDetail of the announcements : ");
        String detail = in.nextLine();

        System.out.println("\n Company announcement Loaded, type \'Save\' to save");
        String saveMsg = in.nextLine();

        String numOfAnnouncements = " ";
        if (saveMsg.equalsIgnoreCase("save")) {
            messagesDBS.add(getNextArrElemnt(), new MessagesDB(subject, detail));


            System.out.println("*** Announcement successfully added to the database! ***\n\n");
            if (messagesDBS.size() == 1) {
                numOfAnnouncements = "There is only " + messagesDBS.size() + " Announcement";
            }else {
                numOfAnnouncements = "There are  " + messagesDBS.size() + " Announcements";
            }
            System.out.println(numOfAnnouncements);
            System.out.println("=============================\n");
            Model.clearScreen();


            Model.displayMenu("page4", LocalAuthDB.role);
            MessagesDB.companyAnnouncementsOption();

        } else {

            System.out.println("!!! announcement not added. Please Re-enter: ");
            addNewAnnouncement();
        }

        //===================================================..

        return "addNewAnnouncement()"; //not sure what to return!!!
    }


    public static String viewCompanyAnnouncements() {
        int count = 0;
        Model.clearScreen();

        if (messagesDBS.size() > 0) {
            for (count = 0; count < messagesDBS.size(); count++) {
                Object msg = messagesDBS.get(count);
                System.out.println(count + ". " + ((MessagesDB) msg).getMsgSubject());      //Displaying announcment Messages
            }

        } else {  //If there is no announcement, Go back to add one
            System.out.println("Ooops!! No Announcements. press 99 to Add an announcement ");
            Scanner myReader = new Scanner(System.in);
            int choice = myReader.nextInt();

            if (choice == 99) {
                addNewAnnouncement();
            }
        }

        Scanner in = new Scanner(System.in);
        System.out.print("\nAnnouncement ID to read Or -1 to go back: ");
        int choice = in.nextInt();
        if (choice == -1) {
            // Model.displayMenu("page1", LocalAuthDB.role);
            Model.listCompanyAnnouncementsMenu();
            Model.displayMenu("page4", LocalAuthDB.role);
            MessagesDB.companyAnnouncementsOption();
        } else if (choice >= 0 && choice <= messagesDBS.size()) {
            Object msg = messagesDBS.get(choice);
            Model.readCompanyAnnouncement();

            System.out.println("\nSubject\t: " + ((MessagesDB) msg).getMsgSubject() + "\n");
            System.out.println("Description\t: " + ((MessagesDB) msg).getMsgDetails() + "\n\n");
            System.out.println("Press -1 to Go back to Announcements :");
            int goBack = in.nextInt();

            if (goBack == -1) {
                Model.readCompanyAnnouncement();
                viewCompanyAnnouncements();
            }/* else if (goBack == -9) {
                Model.displayMenu("page1", LocalAuthDB.role); //go back to main menu
            }*/


        } else {
            System.out.println("!!! Invalid Option !!! Please Re-enter: ");
            viewCompanyAnnouncements();
        }
        return "viewCompanyAnnouncements()";
    }

    public static String deleteCompanyAnnouncement() {
        Model.clearScreen();
        int count = 0;
        if (messagesDBS.size() > 0) {       //View all the announcement to choose one to delete;
            for (count = 0; count < messagesDBS.size(); count++) {
                Object msg = messagesDBS.get(count);
                System.out.println(count + ". " + ((MessagesDB) msg).getMsgSubject());
            }

            Scanner in = new Scanner(System.in);

            System.out.print("\nDelete by Announcement ID  or -1 to Go back: ");
            int selct = in.nextInt();
            if (selct == -1) {
                Model.listCompanyAnnouncementsMenu();
                Model.displayMenu("page4", LocalAuthDB.role);
                MessagesDB.companyAnnouncementsOption();
            }
            messagesDBS.remove(selct);

            System.out.println("Announcement deleted");
            Model.deleteCompanyAnnouncement();
            deleteCompanyAnnouncement();

        } else {
            System.out.println("Ooops!! No Announcements. press 99 to Add an announcement ");
            Scanner myReader = new Scanner(System.in);
            int choice = myReader.nextInt();
            if (choice == 99) {
                addNewAnnouncement();       //back to add new announcement
            }
        }
        return "deleteCompanyAnnouncement()";
    }
}