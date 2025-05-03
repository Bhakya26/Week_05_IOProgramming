package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterHighScoringStudents {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        String line;
        boolean isHeader = true;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            System.out.println("Students who scored more than 80 marks:\n");

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; 
                    continue;
                }

                String[] student = line.split(",");

                
                int marks = Integer.parseInt(student[3].trim());
                if (marks > 80) {
                    System.out.println("ID    : " + student[0]);
                    System.out.println("Name  : " + student[1]);
                    System.out.println("Age   : " + student[2]);
                    System.out.println("Marks : " + student[3]);
                    System.out.println("-----------------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
