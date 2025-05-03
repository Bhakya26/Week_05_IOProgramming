package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;

public class FilterUsersByAge {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("src/main/java/org/example/ddata.json");
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject user = jsonArray.get(i).getAsJsonObject();
                int age = user.get("age").getAsInt();

                if (age > 25) {
                    System.out.println("Name: " + user.get("name").getAsString());
                    System.out.println("Email: " + user.get("email").getAsString());
                    System.out.println("Age: " + age);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

