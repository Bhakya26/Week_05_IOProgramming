package csv;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {
    public static void main(String[] args) {
        String csvFile = "employees.csv"; 
        String line;
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; 
                }
                rowCount++;
            }

            System.out.println("Total number of records (excluding header): " + rowCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
