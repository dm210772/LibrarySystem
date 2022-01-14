package com.company;


import com.company.libraryFunctions.*;
import com.company.objects.Account;

import java.util.Scanner;

public class Main {

    // Code a remove method


    public static String getInput(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        return input.nextLine();
    }

    public static void main(String[] args) {
        //Get stuff from text files and dump into lists in repository
        //Get to main menu, adk what use would like to do
        //For each 'answer' make a new method

        // write your code here
        fileHandling.createFile();

        Scanner myReader = new Scanner(repository.books);
        while (myReader.hasNextLine()) {
            String[] data = myReader.nextLine().split(",");
            Account newAccount = new Account(data[0], data[1]);
            repository.AccountList.add(newAccount);
        }

        loginSystem.menu();
        if (repository.logInComplete) {
            mainMenu();
        }

    }

    public static void mainMenu(){
        boolean again = true;
        while (again) {
            String userChoice = getInput("Would you like to write to, read, or delete the file?");


            switch (userChoice.toLowerCase()) {
                case "write":
                    fileHandling.writeToFile(getInput("Add a book title, ISBN, the author, and the genre."));
                    break;
                case "read":
                    fileHandling.readFile();
                    break;
                case "delete":
                    fileHandling.deleteFile();
                    break;
            }
            if (getInput("Would you like to continue?").equalsIgnoreCase("n")) {
                again = false;
            }
        }
    }
}
