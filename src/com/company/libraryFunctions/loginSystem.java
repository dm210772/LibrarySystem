package com.company.libraryFunctions;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class loginSystem {



    public static void registerLogIn(String username, String account) {
        try {
            FileWriter myWriter = new FileWriter(repository.accounts.getName(), true);
            myWriter.write(username + "," + account + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String getInput(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        return input.nextLine();
    }

    public static void verifyLogIn(String username, String password) {
        try {
            Scanner myReader = new Scanner(repository.accounts);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                if (data[0].equals(username)) {
                    if (data[1].equals(password)) {
                        System.out.println("Password correct. Logging in...");
                        System.out.println("Log in complete.");
                        repository.logInComplete = true;
                        break;
                    } else {
                        System.out.println("Password incorrect.");
                    }
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void menu() {
        // write your code here

        String choice = getInput("Would you like to log in or register an account?");
        if (choice.equalsIgnoreCase("log in")) {
            verifyLogIn(getInput("Username: "), getInput("Password: "));
        } else if (choice.equalsIgnoreCase("register")) {
            registerLogIn(getInput("Username: "), getInput("Password: "));
        } else if (choice.equalsIgnoreCase("close")) {
            System.exit(0);
        }
    }
}
