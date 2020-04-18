package za.co.mahquests.hr.db;
import za.co.mahquests.decoration.Model;
import za.co.mahquests.hr.authenticate.LocalAuthDB;

import java.util.*;

public class HRDocumentsDB {
    private static List<Object> hrDocumentsDBList = null;
    private static String docName;

    private HRDocumentsDB(){
        hrDocumentsDBList = new ArrayList<>();
        hrDocumentsDBList.add(0,"Leave Policy" );
        hrDocumentsDBList.add(1,"Telephone Policy " );
        hrDocumentsDBList.add(2,"Printing and Photocopying Policy" );
        hrDocumentsDBList.add(3,"Dress Code " );
        hrDocumentsDBList.add(4,"Business Travel" );
        hrDocumentsDBList.add(5,"Non-Smoking Policy" );
        hrDocumentsDBList.add(6,"Discipline Policy" );
        hrDocumentsDBList.add(7,"Grievance Policy and Procedure" );
        hrDocumentsDBList.add(8,"Sexual Harassment Policy" );
        hrDocumentsDBList.add(9,"Retrenchment Policy and Procedure" );
        hrDocumentsDBList.add(10,"Remuneration Policy " );
        hrDocumentsDBList.add(11,"Incentive/Recognition/Rewards/Bonus Policy" );
        hrDocumentsDBList.add(12,"Induction Policy" );
        hrDocumentsDBList.add(13,"Skills Development and Training Policy" );
        hrDocumentsDBList.add(14,"Study Policy" );
        hrDocumentsDBList.add(15,"Job Evaluation" );
        hrDocumentsDBList.add(16,"Conflict of Interest " );
        hrDocumentsDBList.add(17,"Confidentiality" );
        hrDocumentsDBList.add(18,"Copyright Work" );
        hrDocumentsDBList.add(19,"Violation of Policies" );
        hrDocumentsDBList.add(20,"Anti-bribery and Corruption Policy" );
        hrDocumentsDBList.add(21,"Acceptable Use of Information Assets Policy" );
        hrDocumentsDBList.add(22,"Company Property Acknowledgement of Receipt" );

    }
    public static HRDocumentsDB loadHRDocument(){
        return new HRDocumentsDB();
    }
    public static void addHRDocument(){
        //add Hr document
    }
    public static void viewListOfHRDocuments() {

        loadHRDocument();
        Model.clearScreen();

        int count;
        if (hrDocumentsDBList.size() > 0) {
            for (count = 1; count < hrDocumentsDBList.size(); count++) {
                Object hrDoc = hrDocumentsDBList.get(count);
                System.out.println(count + ". " + hrDoc);  //Displaying
            }
            System.out.println("[Add] [Back]");
            Scanner in = new Scanner(System.in);
            String option = in.next();
            if (option.equalsIgnoreCase("back")) {

                Model.displayMenu("page1", LocalAuthDB.role);

            }else if (option.equalsIgnoreCase("add")){
                Model.displayMenu("page1", LocalAuthDB.role);
            }

        } else {  //If there is no announcement, Go back to add one
            System.out.println(" No HR Documents.");
            Scanner myReader = new Scanner(System.in);
            int choice = myReader.nextInt();
            if (choice == 1) {
                addHRDocument();
            }
        }
    }
}
