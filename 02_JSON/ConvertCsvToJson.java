package org.example;

import org.json.CDL;
import org.json.JSONArray;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertCsvToJson {
    public static void main(String[] args) {
        try {
            String csv = new String(Files.readAllBytes(Paths.get("src/main/java/org/example/data.json")));
            JSONArray jsonArray = CDL.toJSONArray(csv);

            if (jsonArray == null) {
                System.out.println("Invalid CSV format or missing header.");
                return;
            }

            System.out.println(jsonArray.toString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
