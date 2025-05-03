package org.example;

import org.json.JSONObject;
import org.json.XML;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertjsonToXml {
    public static void main(String[] args) {
        try {
            String json = new String(Files.readAllBytes(Paths.get("src/main/java/org/example/data.json")));
            JSONObject jsonObject = new JSONObject(json);

            String xml = XML.toString(jsonObject);
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
