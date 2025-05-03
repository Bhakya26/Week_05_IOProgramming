package org.example;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.util.Map;

public class PrintJsonKeysValues {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("src/main/java/org/example/data1.json");
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            for (Map.Entry<String, com.google.gson.JsonElement> entry : jsonObject.entrySet()) {
                System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
