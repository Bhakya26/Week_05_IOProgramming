import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

public class JsonCsv {

    // Convert JSON file to CSV file
    public static void jsonToCsv(String jsonInputPath, String csvOutputPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonInputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvOutputPath))) {

            StringBuilder jsonText = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonText.append(line);
            }

            JSONArray jsonArray = new JSONArray(jsonText.toString());

            // Write header
            if (jsonArray.length() > 0) {
                JSONObject first = jsonArray.getJSONObject(0);
                writer.write(String.join(",", first.keySet()));
                writer.newLine();
            }

            // Write each row
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                List<String> row = new ArrayList<>();
                for (String key : obj.keySet()) {
                    row.add(obj.get(key).toString());
                }
                writer.write(String.join(",", row));
                writer.newLine();
            }

            System.out.println("✅ JSON successfully converted to CSV!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Convert CSV file to JSON file
    public static void csvToJson(String csvInputPath, String jsonOutputPath) {
        JSONArray jsonArray = new JSONArray();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvInputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(jsonOutputPath))) {

            String headerLine = reader.readLine();
            if (headerLine == null) throw new RuntimeException("CSV file is empty!");

            String[] headers = headerLine.split(",");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",", -1);
                JSONObject obj = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    String key = headers[i].trim();
                    String value = values[i].trim();
                    try {
                        obj.put(key, Integer.parseInt(value));
                    } catch (NumberFormatException e) {
                        obj.put(key, value);
                    }
                }
                jsonArray.put(obj);
            }

            writer.write(jsonArray.toString(2));
            System.out.println("✅ CSV successfully converted to JSON!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main method to test both conversions
    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "students.csv";
        String outputJson = "students_converted_back.json";

        // Convert JSON to CSV
        jsonToCsv(jsonFile, csvFile);

        // Convert back from CSV to JSON
        csvToJson(csvFile, outputJson);
    }
}
