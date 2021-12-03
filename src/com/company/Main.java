package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Code a remove method

    static File books = new File("books.txt");

    public static String getInput(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        return input.nextLine();
    }

    public static void createFile() {
        try {
            if (books.createNewFile()) {
                System.out.println("File created: " + books.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String userInput) {
        try {
            FileWriter myWriter = new FileWriter(books.getName(), true);
            myWriter.write(userInput + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try {
            Scanner myReader = new Scanner(books);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                System.out.println(Arrays.toString(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void deleteFile() {
        if (books.delete()) {
            System.out.println("Deleted the file: " + books.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void main(String[] args) {
        // write your code here
        createFile();
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
