
import common.InputOutput;
import entity.Person;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class FileManager {
    private static final String DELIMITER = ";";

    public List<Person> readPeopleFromFile(String filePath) {
        List<Person> people = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(DELIMITER);

                if (parts.length >= 3) {
                    String name = parts[0];
                    String address = parts[1];
                    double salary = parseSalary(parts[2]);

                    Person person = new Person(name, address, salary);
                    people.add(person);
                }
            }
        } catch (FileNotFoundException e) {
            InputOutput.displayMessage("File not found.");
        }

        return people;
    }

    private double parseSalary(String salaryString) {
        try {
            return Double.parseDouble(salaryString);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public void writeWordsToFile(String inputFilePath, String outputFilePath) throws IOException {
        Set<String> uniqueWords = new HashSet<>();

        try (Scanner scanner = new Scanner(new File(inputFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {

            while (scanner.hasNext()) {
                String word = scanner.next();
                uniqueWords.add(word);
            }

            for (String word : uniqueWords) {
                writer.println(word);
            }
        } catch (FileNotFoundException e) {
            InputOutput.displayMessage("Input file not found.");
        } catch (IOException e) {
            InputOutput.displayMessage("Error writing output file.");
        }
    }
}
