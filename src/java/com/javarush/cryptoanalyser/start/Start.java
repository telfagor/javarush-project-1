package com.javarush.cryptoanalyser.start;

import com.javarush.cryptoanalyser.alphabet.EncryptedAlphabet;
import com.javarush.cryptoanalyser.file.Decrypt;
import com.javarush.cryptoanalyser.file.Encrypt;
import com.javarush.cryptoanalyser.validator.Validator;

import java.util.Scanner;

public class Start {
    private final EncryptedAlphabet ENCRYPTED_ALPHABET = new EncryptedAlphabet();
    private final Validator VALIDATOR = new Validator();
    private final Encrypt ENCRYPT = new Encrypt();
    private final Decrypt DECRYPT = new Decrypt();

    private void showMenu() {
        System.out.println("Welcome to our fast encode/decode program!");
        System.out.println("Menu:");
        System.out.println("1. Encode");
        System.out.println("2. Decode");
        System.out.print("Select the option: ");
    }

    public void init() {
        showMenu();
        Scanner scanner = new Scanner(System.in);
        int operation = VALIDATOR.getOption(scanner);
        System.out.print("Enter the key: ");
        int key = VALIDATOR.getOption(scanner);
        String source = VALIDATOR.validateFilePath("C:\\Users\\Andrei\\IdeaProjects\\javarush-project-1\\src\\java\\source.txt");
        String dest = VALIDATOR.validateFilePath("C:\\Users\\Andrei\\IdeaProjects\\javarush-project-1\\src\\java\\encrypted_file.txt");
        String decrypted_file = VALIDATOR.validateFilePath("C:\\Users\\Andrei\\IdeaProjects\\javarush-project-1\\src\\java\\decrypted_file.txt");
        char[] encryptedAlphabet = ENCRYPTED_ALPHABET.getEncryptedAlphabet(key);

        switch (operation) {
            case 1 -> {
                ENCRYPT.encode(source, dest, key, encryptedAlphabet);
                System.out.println("The file encrypted!");
            }

            case 2 -> {
                DECRYPT.decode(dest, decrypted_file, key, encryptedAlphabet);
                System.out.println("The file decrypted!");
            }

            default -> {
                System.out.println("This option does not exist!");
                System.out.println("Have a nice day!");
            }
        }
    }
}
