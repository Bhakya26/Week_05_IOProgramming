package csv;
import java.io.*;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String inputFile = "students.csv";
        Set<String> seenIds = new HashSet<>();
        List<String> duplicateLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String header = reader.readLine(); 
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length >= 1) {
                    String id = parts[0].trim();
                    if (!seenIds.add(id)) {
                        duplicateLines.add(line);
                    }
                }
            }

            if (duplicateLines.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records:");
                for (String dup : duplicateLines) {
                    System.out.println("Duplicate record found: " + dup);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
