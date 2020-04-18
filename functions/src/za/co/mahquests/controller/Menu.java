package za.co.mahquests.controller;

import za.co.mahquests.decoration.Model;
import za.co.mahquests.hr.authenticate.LocalAuthDB;
import za.co.mahquests.hr.db.EmployeeDB;
import za.co.mahquests.hr.db.HRDocumentsDB;
import za.co.mahquests.hr.db.MessagesDB;
import za.co.mahquests.hr.db.TrainingDB;

import java.util.Scanner;

public class Menu {
    public static void chooseOption(String menu, String role) {
        Scanner in = new Scanner(System.in);

        if (menu.equals("page1")) {
            System.out.print("Your selection : ");
            String userChoice = in.next();

            if (role.equals("admin")) {

                switch (userChoice) {
                    case "1":
                        EmployeeDB.addUserForm();
                        break;
                    case "2":
                        EmployeeDB.showListOfUser();
                        break;
                    case "3":
                        Model.displayMenu("page3", LocalAuthDB.role);
                        EmployeeDB.searchFunction();
                        break;
                    case "4":
                        Model.listCompanyAnnouncementsMenu();
                        Model.displayMenu("page4", LocalAuthDB.role);
                        MessagesDB.companyAnnouncementsOption();
                        break;
                    case "5":
                        Model.showMonthlyTrainingMenu();
                        Model.displayMenu("page5", LocalAuthDB.role);
                        TrainingDB.trainingFunctionOption();
                        break;
                    case "6":
                        Model.showHRDocuments();
                        HRDocumentsDB.viewListOfHRDocuments();
                    case "7":
                        System.exit(0);
                    default:
                        System.out.println("Invalid option, please select a valid choice [1 - 6] ");
                        chooseOption("page1", "admin");
                }
            } else {

                switch (userChoice) {
                    case "1":
                        System.out.println("User Page 1 - Option 1");
                        break;
                    case "2":
                        System.out.println("User Page 1 - Option 2");
                        break;
                    case "3":
                        System.out.println("User Page 1 - Option 3");
                        break;
                    case "4":
                        System.out.println("User Page 1 - Option 4");
                        break;
                    case "5":
                        System.exit(0);
                    default:
                        System.out.println("Invalid option, please select a valid choice [1 - 5] ");
                        chooseOption("page1", "admin");
                }


            }
        }
    }
}
