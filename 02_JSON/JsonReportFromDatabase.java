package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.*;

public class JsonReportFromDatabase {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        String sql = "SELECT id, name, email FROM users";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            List<Map<String, Object>> resultList = new ArrayList<>();

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnLabel(i), rs.getObject(i));
                }
                resultList.add(row);
            }

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(resultList);
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
