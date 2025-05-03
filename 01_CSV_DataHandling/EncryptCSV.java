package csv;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class EncryptCSV {
    public static void main(String[] args) {
        String file = "encrypted_employees.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("ID,Name,Email,Salary");
            writer.newLine();

            String[][] data = {
                {"1", "Alice", "alice@example.com", "70000"},
                {"2", "Bob", "bob@example.com", "85000"}
            };

            for (String[] row : data) {
                String encryptedEmail = AESUtil.encrypt(row[2]);
                String encryptedSalary = AESUtil.encrypt(row[3]);
                writer.write(String.join(",", row[0], row[1], encryptedEmail, encryptedSalary));
                writer.newLine();
            }

            System.out.println("✅ Encrypted CSV written successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

