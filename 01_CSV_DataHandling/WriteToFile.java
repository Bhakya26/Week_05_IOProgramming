package csv;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        String csvFile = "employees.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {
            
            writer.append("ID,Name,Department,Salary\n");

       
            writer.append("201,John,HR,50000\n");
            writer.append("202,Alice,IT,60000\n");
            writer.append("203,Bob,Finance,55000\n");
            writer.append("204,Eva,Marketing,52000\n");
            writer.append("205,Tom,IT,58000\n");

            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

