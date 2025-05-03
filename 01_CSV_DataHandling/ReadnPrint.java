package csv;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadnPrint{
    public static void main(String[] args) {
        String csvFile = "students.csv"; 
        String line;
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; 
                }

                String[] student = line.split(splitBy);
                System.out.println("Student ID: " + student[0]);
                System.out.println("Name      : " + student[1]);
                System.out.println("Age       : " + student[2]);
                System.out.println("Marks     : " + student[3]);
                System.out.println("-----------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

