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

        } else if(choice == 4){
            Model.editCompanyAnnouncement();
            updateCompanyAnnouncement();

        } else if (choice == 5) {
            Model.displayMenu("page1", LocalAuthDB.role);
        } else {
            System.out.println("!!!  Invalid Option  !!!. Please Re-Enter: \n");
            Model.displayMenu("page4", LocalAuthDB.role);
            MessagesDB.companyAnnouncementsOption();

        }

    }


    public static void addNewAnnouncement() {  //*add a "Add new" *

        Model.clearScreen();
        //Model.addCompanyAnnouncements();

        Scanner in = new Scanner(System.in);

        System.out.print("\nSubject of your new announcement : ");
        String subject = in.nextLine();

        System.out.print("\nDetail of the announcements : ");
        String detail = in.nextLine();

        System.out.println("\n Company announcement Loaded, type \'Save\' to save");
        String saveMsg = in.nextLine();

        String numOfAnnouncements;
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

       // return "addNewAnnouncement()"; //not sure what to return!!!
    }

    public static void updateCompanyAnnouncement() {
        Model.clearScreen();
        //Model.editCompanyAnnouncement();

        int count;
        Scanner myReader = new Scanner(System.in);

        if (messagesDBS.size() > 0) {
            for (count = 0; count < messagesDBS.size(); count++) {
                Object msg = messagesDBS.get(count);
                System.out.println(count + ". " + ((MessagesDB) msg).getMsgSubject());      //Displaying announcment Messages
            } //Displaying all announcements

            System.out.println("Please choose announcement to update :");
            int choice = myReader.nextInt();
            String editSubject = " ";

            if (choice >= 0 && choice <= messagesDBS.size()) {
                Object msg = messagesDBS.get(choice);
                Model.clearScreen();
                Model.readCompanyAnnouncement();
                System.out.println("\n1. Subject\t\t: " + ((MessagesDB) msg).getMsgSubject() + "\n");
                System.out.println("2. Description\t: " + ((MessagesDB) msg).getMsgDetails() + "\n");
                System.out.println("Please choose what to update on the announcement: ");
                int option = myReader.nextInt();


                if (option == 1) {

                    Scanner in = new Scanner(System.in);
                    System.out.println("please update the subject of the announcement: ");
                    String tempSubj = in.nextLine();


                    System.out.println("\n Company announcement Loaded, type \'Save\' to save");
                    String saveMsg = in.nextLine();

                    if (saveMsg.equalsIgnoreCase("save")) {

                        String tempDet = ((MessagesDB) msg).getMsgDetails();
                        messagesDBS.set(choice, new MessagesDB(tempSubj,tempDet));
                        System.out.println("\n - " + ((MessagesDB) msg).getMsgSubject() + " - Has Been Updated to \""+tempSubj + "\" \n");
                    }
           /* if (choice == messagesDBS.) {

                Object msg = messagesDBS.get(choice);
                System.out.println(count + ". " + ((MessagesDB) msg).getMsgSubject());
                messagesDBS.set(choice, new MessagesDB(subject, detail));
            }*/

                }else if (option == 2) {

                    Scanner in = new Scanner(System.in);
                    System.out.println("please update the Details of the announcement: ");
                    String tempDet = in.nextLine();


                    System.out.println("\n Company announcement Loaded, type \'Save\' to save");
                    String saveMsg = in.nextLine();

                    if (saveMsg.equalsIgnoreCase("save")) {

                        String tempSubj = ((MessagesDB) msg).getMsgSubject();
                        messagesDBS.set(choice, new MessagesDB(tempSubj,tempDet));
                        System.out.println("\n - " + ((MessagesDB) msg).getMsgDetails() + " - Has Been Updated to \""+tempDet + "\" \n");


                    }
                }
                Model.listCompanyAnnouncementsMenu();
                Model.displayMenu("page4", LocalAuthDB.role);
                MessagesDB.companyAnnouncementsOption();


            }
        }
    }
    public static String viewCompanyAnnouncements() {

        Model.clearScreen();
        Model.listCompanyAnnouncementsMenu();
        int count;
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
            System.out.println("0. Go back to Announcements");
            System.out.println("1. Update Announcement");
            int selection = in.nextInt();

            if (selection == 0) {
                Model.readCompanyAnnouncement();
                viewCompanyAnnouncements();
            }else if (selection == 1) {
                updateCompanyAnnouncement();
            }else {
                System.out.println("*** INVALID Option, please re-enter");

            }


        } else {
            System.out.println("!!! Invalid Option !!! Please Re-enter: ");
            viewCompanyAnnouncements();
        }
        return "viewCompanyAnnouncements()";
    }

    public static String deleteCompanyAnnouncement() {
        Model.clearScreen();
        int count;
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