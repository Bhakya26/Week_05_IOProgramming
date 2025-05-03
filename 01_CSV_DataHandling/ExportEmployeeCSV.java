package csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class ExportEmployeeCSV {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_user";
        String password = "your_password";
        String csvFile = "employee_report.csv";

        String query = "SELECT id, name, department, salary FROM employees";

        try (
            Connection conn = DriverManager.getConnection(jdbcURL, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))
        ) {
            // Write header
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            // Write data rows
            while (rs.next()) {
                String row = rs.getInt("id") + "," +
                             rs.getString("name") + "," +
                             rs.getString("department") + "," +
                             rs.getDouble("salary");
                writer.write(row);
                writer.newLine();
            }

            System.out.println("✅ CSV report generated: " + csvFile);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

