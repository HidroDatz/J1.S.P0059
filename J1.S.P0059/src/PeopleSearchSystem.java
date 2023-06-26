
import common.InputOutput;
import entity.Person;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class PeopleSearchSystem {
    private FileManager fileManager;

    public PeopleSearchSystem() {
        fileManager = new FileManager();
    }

    public void start() {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = InputOutput.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    findPersonInfo();
                    break;
                case 2:
                    copyTextToFile();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    InputOutput.displayMessage("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void displayMenu() {
        InputOutput.displayMessage("MENU");
        InputOutput.displayMessage("1. Find person information");
        InputOutput.displayMessage("2. Copy text to new file");
        InputOutput.displayMessage("3. Exit program");
    }

    private void findPersonInfo() {
        InputOutput.displayMessage("Find person information");
        String filePath = InputOutput.getStringInput("Enter the file path: ");
        double minSalary = InputOutput.getDoubleInput("Enter the minimum salary: ");

        List<Person> people = fileManager.readPeopleFromFile(filePath);
        List<Person> matchedPeople = new ArrayList<>();

        double highestSalary = Double.MIN_VALUE;
        double lowestSalary = Double.MAX_VALUE;

        for (Person person : people) {
            if (person.getSalary() >= minSalary) {
                matchedPeople.add(person);
                highestSalary = Math.max(highestSalary, person.getSalary());
                lowestSalary = Math.min(lowestSalary, person.getSalary());
            }
        }

        InputOutput.displayMessage("Matched People:");
        InputOutput.displayPeople(matchedPeople);

        InputOutput.displayMessage("Highest Salary: " + highestSalary);
        InputOutput.displayMessage("Lowest Salary: " + lowestSalary);
    }

    private void copyTextToFile() throws IOException {
        InputOutput.displayMessage("Copy text to new file");
        String inputFilePath = InputOutput.getStringInput("Enter the input file path: ");
        String outputFilePath = InputOutput.getStringInput("Enter the output file path: ");

        fileManager.writeWordsToFile(inputFilePath, outputFilePath);

        InputOutput.displayMessage("Text copied to new file successfully.");
    }
}
