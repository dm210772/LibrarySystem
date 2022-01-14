package com.company.libraryFunctions;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class fileHandling {



    public static void createFile() {
        try {
            if (repository.books.createNewFile()) {
                System.out.println("File created: " + repository.books.getName());
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
            FileWriter myWriter = new FileWriter(repository.books.getName(), true);
            myWriter.write(userInput + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try {
            Scanner myReader = new Scanner(repository.books);
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
        if (repository.books.delete()) {
            System.out.println("Deleted the file: " + repository.books.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
