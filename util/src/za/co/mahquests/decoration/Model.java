package za.co.mahquests.decoration;

public class Model {
    public static void header() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("****                                                  ***");
        System.out.println("*          MaH Quests HR Application Login Page         *");
        System.out.println("****                                                  ***");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void welcomeMessage() {

        System.out.println("***** MaH Quests Enterprises HR System ****");
        System.out.println("*****          FRONT MENU PAGE         ****");
        System.out.println("\nPlease select an option: [eg. 1] ");
    }

    public static void displayMenu(String menu, String role) {


        if (menu.equals("page1")) {
            if (role.equals("admin")) {
                System.out.println("1. Add New Employee");
                System.out.println("2. List all employees");
                System.out.println("3. Search for employee");
                System.out.println("4. Company wide announcements");
                System.out.println("5. Training schedules");
                System.out.println("6. Exit");

            } else {
                System.out.println("1. View my profile");
                System.out.println("2. Book for leave");
                System.out.println("3. View my training schedule ");
                System.out.println("4. View company announcements");
                System.out.println("5. Exit");
            }
        }

        if (menu.equals("page3")) {
            searchForEmployee();
            System.out.println("1. Search by First Name");
            System.out.println("2. Search by Last Name");
            System.out.println("3. Search by Employee ID");
            System.out.println("4. Back to Main Menu");
        }

        if (menu.equals("page4")) {
            if (role.equals("admin")) {
                System.out.println("1. Add New Company Announcement");
                System.out.println("2. View Company Announcements");
                System.out.println("3. Delete A Company Announcements");
                System.out.println("4. Back to Main Menu");

            } else {
                System.out.println("1. View New Company Announcements");
                System.out.println("2. View All Company Announcements");
                System.out.println("3. Back to Main Menu");
            }
        }

        if (menu.equals("page5")) {
            System.out.println("1. Add New Training");
            System.out.println("2. View Training Schedule");
            System.out.println("3. Delete scheduled training");
            System.out.println("4. Back to Main Menu");
        }

        if (menu.equals("page6")) {

            System.out.println("1. January");
            System.out.println("2. February");
            System.out.println("3. March");
            System.out.println("4. April");
            System.out.println("5. May");
            System.out.println("6. June");
            System.out.println("7. July");
            System.out.println("8. August");
            System.out.println("9. September");
            System.out.println("10. October");
            System.out.println("11. November");
            System.out.println("12. December");
            System.out.println("0. Back to Main Menu");
        }

    }

    public static void addUserForm() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*       MaH Quests HR Application Add User Form:        *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void listOfEmployees() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*     MaH Quests HR Application Employees List Page     *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void viewEmployeeDetail() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*      MaH Quests HR Application Employees Details      *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void updateEmployeeDetail() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*   MaH Quests HR Application Update Employees Details  *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void searchForEmployee() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*     MaH Quests HR Application Search for Employee     *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void searchEmployeeByFirstName() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*    MaH Quests HR Application Search by First Name     *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void searchEmployeeByLastName() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*     MaH Quests HR Application Search by Last Name     *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void searchEmployeeByEmpID() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*      MaH Quests HR Application Search by Emp ID       *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void listCompanyAnnouncementsMenu() {
        System.out.println("**********************************************************");
        System.out.println("****                                                   ***");
        System.out.println("*  MaH Quests HR Application Company Announcements Menu  *");
        System.out.println("****                                                   ***");
        System.out.println("**********************************************************");
    }

    public static void addCompanyAnnouncements() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*    MaH Quests HR Application Company Announcements    *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void readCompanyAnnouncement() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*      MaH Quests HR Application Read Announcement      *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void deleteCompanyAnnouncement() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*      MaH Quests HR Application Delete Announcement    *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }
    public static void editCompanyAnnouncement(){
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*      MaH Quests HR Application Update Announcement    *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }


    public static void showMonthlyTrainingMenu() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*            MaH Quests HR Monthly Training             *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void addTrainingToMonthMenu() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*            MaH Quests HR Monthly Training             *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void viewCompanyTraining() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*      MaH Quests HR Application Read Announcement      *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }

    public static void deleteCompanyTraining() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*      MaH Quests HR Application Delete Announcement    *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }
    public static void updateCompanyTraining() {
        System.out.println("*********************************************************");
        System.out.println("****                                                  ***");
        System.out.println("*      MaH Quests HR Application Delete Announcement    *");
        System.out.println("****                                                  ***");
        System.out.println("*********************************************************");
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
