package csv;

import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "largefile.csv";
        int chunkSize = 100;
        int totalRecords = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String header = reader.readLine(); 
            System.out.println("Header: " + header);

            String line;
            int chunkCount = 0;

            while ((line = reader.readLine()) != null) {
                
                chunkCount++;
                totalRecords++;

                
                if (chunkCount == chunkSize) {
                    System.out.println("Processed " + totalRecords + " records so far...");
                    chunkCount = 0;
                    
                }
            }

            
            if (chunkCount > 0) {
                System.out.println("Processed " + totalRecords + " records total.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
