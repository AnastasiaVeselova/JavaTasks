package ru.academits.oop.february2019.veselova.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingFile {
    public static ArrayList<String> readFile(String filePath) {
        ArrayList<String> linesFromFile = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            while (scanner.hasNext()) {
                linesFromFile.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File: " + filePath + " is not found.");
        }
        return linesFromFile;
    }
}
