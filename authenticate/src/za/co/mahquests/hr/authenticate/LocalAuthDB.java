package za.co.mahquests.hr.authenticate;

import za.co.mahquests.decoration.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LocalAuthDB {
    public static boolean loginResult = true;
    public static String role = "user";
    private static String username;
    private static Map<String, String> dbUserPass;

    private LocalAuthDB() {
        dbUserPass = new HashMap();
        dbUserPass.put("admin", "pa55w0rd");
        dbUserPass.put("thato.mohono", "pa55w0rd321");
        dbUserPass.put("tumo.mohono", "pa55w0rd231");
        dbUserPass.put("beverly.sithole", "pa55w0rd213");
        dbUserPass.put("david.maile", "pa55w0rd132");
        dbUserPass.put("carl.sekwati", "pa55w0rd312");
        dbUserPass.put("masego.mokakale", "pa55w0rd123");
    }

    public static LocalAuthDB getConnection() {
        return new LocalAuthDB();
    }

    public static void authenticateUser(String username) {

        LocalAuthDB db = LocalAuthDB.getConnection();

        Scanner in = new Scanner(System.in);

        if (username.equals("page-0")) {
            Model.header();

            while (true) {

                System.out.print("Please enter your Username : ");
                String usrname = in.next();

                if (db.checkUsername(usrname)) {
                    username = usrname;
                    getUserPassword();
                    break;
                }

                Model.clearScreen();
                System.out.println("\n\n\n\nUsername incorrect, please try again...");
                break;
            }
        }
    }

    private static void getUserPassword() {

        LocalAuthDB db = LocalAuthDB.getConnection();

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter your Password : ");
        String password = in.next();

        if (db.checkPassword(password)) {
            loginResult = false;
            System.out.println("\nWelcome " + username + ", you have successfully logged in. ");
            if (username.equals("admin")) {
                role = "admin";
            }
            Model.welcomeMessage();
        } else {
            System.out.println("\nPassword incorrect, please login again...\n\n\n\n");
            authenticateUser("page-0");
        }

    }

    public boolean checkUsername(String username) {
        if (dbUserPass.containsKey(username)) {
            LocalAuthDB.username = username;
            return true;
        }
        return false;
    }

    public boolean checkPassword(String password) {
        String dbPass = dbUserPass.get(username);
        return dbPass.equals(password);
    }


}
