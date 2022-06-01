package com.javarush.cryptoanalyser.validator;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Scanner;

public class Validator {
    public String validateFilePath(String fileName) {
        try {
            Path filePath = Path.of(fileName);
            if (Files.isDirectory(filePath)) {
                throw new IllegalArgumentException("Path is directory.");
            }
            if (!Files.isReadable(filePath)) {
                throw new IllegalArgumentException("File is not readable");
            }
        } catch (InvalidPathException e) {
            throw new IllegalArgumentException("Path is incorrect", e);
        }
        return fileName;
    }

    public int getOption(Scanner in) {
        int operation;
        while (true) {
            try {
                operation = Integer.parseInt(in.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("You must to introduce an integer number! Try again!");

                in.nextLine();
            }
            in.nextLine();
        }
        return operation;
    }
}
