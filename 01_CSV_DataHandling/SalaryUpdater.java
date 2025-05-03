package csv;

import java.io.*;
import java.util.*;

public class SalaryUpdater {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line = reader.readLine(); 
            writer.write(line);
            writer.newLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    String department = parts[2].trim();
                    double salary = Double.parseDouble(parts[3].trim());

                    if (department.equalsIgnoreCase("IT")) {
                        salary *= 1.10; 
                        parts[3] = String.format("%.2f", salary);
                    }

                    writer.write(String.join(",", parts));
                    writer.newLine();
                }
            }

            System.out.println("Updated CSV saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
