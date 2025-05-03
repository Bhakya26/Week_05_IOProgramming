package csv;

import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "studentdetailss.csv";
        String file2 = "StudentGrade.csv";
        String outputFile = "merged_students.csv";

        Map<String, String[]> studentInfo = new HashMap<>();

        try (
            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            reader1.readLine(); // Skip header
            String line;
            while ((line = reader1.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length >= 3) {
                    String id = parts[0].trim();     // Trim to remove whitespace
                    String name = parts[1].trim();
                    String age = parts[2].trim();
                    studentInfo.put(id, new String[]{name, age});
                }
            }

            writer.write("ID,Name,Age,Marks,Grade");
            writer.newLine();

            reader2.readLine(); // Skip header
            while ((line = reader2.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length >= 3) {
                    String id = parts[0].trim();      // Trim here too
                    String marks = parts[1].trim();
                    String grade = parts[2].trim();

                    if (studentInfo.containsKey(id)) {
                        String[] info = studentInfo.get(id);
                        String name = info[0];
                        String age = info[1];
                        writer.write(String.join(",", id, name, age, marks, grade));
                        writer.newLine();
                    } else {
                        System.out.println("⚠️ ID not found in studentdetailss.csv: " + id);
                    }
                }
            }

            System.out.println("✅ Merged data written to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
