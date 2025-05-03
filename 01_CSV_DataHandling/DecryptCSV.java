package csv;

import java.io.BufferedReader;
import java.io.FileReader;

public class DecryptCSV {
    public static void main(String[] args) {
        String file = "encrypted_employees.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String header = reader.readLine(); // skip header
            System.out.println(header);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                String decryptedEmail = AESUtil.decrypt(parts[2]);
                String decryptedSalary = AESUtil.decrypt(parts[3]);
                System.out.println(parts[0] + "," + parts[1] + "," + decryptedEmail + "," + decryptedSalary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

