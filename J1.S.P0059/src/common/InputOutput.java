/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import entity.Person;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class InputOutput {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String prompt) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return value;
    }

    public static double getDoubleInput(String prompt) {
        double value = 0.0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return value;
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayPeople(List<Person> people) {
        System.out.println("--------------------------------------");
        System.out.println("Name\t\tAddress\t\tSalary");
        System.out.println("--------------------------------------");

        for (Person person : people) {
            System.out.printf("%s\t\t%s\t\t%.2f%n", person.getName(), person.getAddress(), person.getSalary());
        }

        System.out.println("--------------------------------------");
    }
}
