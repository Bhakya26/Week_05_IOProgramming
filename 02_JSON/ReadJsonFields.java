package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;

public class ReadJsonFields {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("src/main/java/org/example/data.json");
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            String name = jsonObject.get("name").getAsString();
            String email = jsonObject.get("email").getAsString();
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
