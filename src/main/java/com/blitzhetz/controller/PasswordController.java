package com.blitzhetz.controller;

import com.blitzhetz.model.PasswordModel;
import com.blitzhetz.view.PasswordView;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PasswordController {

    private PasswordModel model;
    private PasswordView view;
    private Scanner scanner;

    public PasswordController(PasswordModel model, PasswordView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void startApplication() {
        view.initialScreen();

        boolean running = true;
        while (running) {
            view.displayOptions();
            int choice = -1;

            try {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    addPassword();
                    break;
                case 2:
                    getPasswords();
                    break;
                case 3:
                    copyPassword();
                    break;
                case 4:
                    generatePassword();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void addPassword() {
        System.out.println("Enter service name:");
        String serviceName = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        model.addPassword(serviceName, password);
        view.displayMessage("Password added");
    }

    public void addPassword(String name, String password) {
        model.addPassword(name, password);
        view.displayMessage("Password added");
    }

    public void getPasswords() {
        List<String> passwords = model.getPasswords();
        view.displayPasswords(passwords);
    }

    private void copyPassword() {
        System.out.println("Enter service name to copy password:");
        String serviceName = scanner.nextLine();
        model.copyPassword(serviceName);
    }

    public void copyPassword(String name) {
        model.copyPassword(name);
    }

    public void generatePassword() {
        System.out.println("How long password you want to be:");
        int length = scanner.nextInt();
        model.generatePassword(length);
    }

    public void generatePassword(int length) {
        model.generatePassword(length);
    }
}
