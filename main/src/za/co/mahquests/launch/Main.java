package za.co.mahquests.launch;

import za.co.mahquests.controller.Workflow;
import za.co.mahquests.hr.authenticate.LocalAuthDB;

public class Main {
    public static void main(String[] args) {

        do {
            LocalAuthDB.authenticateUser("page-0");

        } while (LocalAuthDB.loginResult);

        Workflow.pageOne();

    }
}
