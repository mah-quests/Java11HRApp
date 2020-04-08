package za.co.mahquests.controller;

import za.co.mahquests.decoration.Model;
import za.co.mahquests.hr.authenticate.LocalAuthDB;

public class Workflow {
    public static void pageOne() {
        Model.displayMenu("page1", LocalAuthDB.role);
        Menu.chooseOption("page1", LocalAuthDB.role);
        pageOne();
    }

}
