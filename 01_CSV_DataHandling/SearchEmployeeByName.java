package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployeeByName {
    public static void main(String[] args) {
        String csvFile = "employees.csv";
        String line;
        boolean isHeader = true;
        boolean found = false;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header
                    continue;
                }

                String[] emp = line.split(",");
                String name = emp[1].trim();

                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("\nEmployee Found:");
                    System.out.println("Department: " + emp[2]);
                    System.out.println("Salary    : " + emp[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

