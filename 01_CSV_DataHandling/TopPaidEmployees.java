package csv;

import java.io.*;
import java.util.*;

public class TopPaidEmployees {
    public static void main(String[] args) {
        String inputFile = "employeedetails.csv";
        List<String[]> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String header = reader.readLine(); 
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    records.add(parts);
                }
            }

            records.sort((a, b) -> {
                double salaryA = Double.parseDouble(a[3].trim());
                double salaryB = Double.parseDouble(b[3].trim());
                return Double.compare(salaryB, salaryA); 
            });

            System.out.println(header);
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                String[] record = records.get(i);
                System.out.println(String.join(",", record));
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

