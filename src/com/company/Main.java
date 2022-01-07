package com.company;

import java.io.File;
import com.company.fileHandling.*;
import java.util.Scanner;

public class Main {

    // Code a remove method

    static File books = new File("books.txt");

    public static String getInput(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        return input.nextLine();
    }

    public static void main(String[] args) {
        // write your code here
        fileHandling.createFile();
        boolean again = true;
        while (again) {
            String userChoice = getInput("Would you like to write to, read, or delete the file?");


            switch (userChoice.toLowerCase()) {
                case "write":
                    writeToFile(getInput("Add a book title, ISBN, the author, and the genre."));
                    break;
                case "read":
                    readFile();
                    break;
                case "delete":
                    deleteFile();
                    break;
            }
            if (getInput("Would you like to continue?").equalsIgnoreCase("n")) {
                again = false;
            }
        }
    }
}
