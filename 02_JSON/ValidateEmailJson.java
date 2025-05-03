//package org.example;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.everit.json.schema.*;
//import org.everit.json.schema.loader.SchemaLoader;
//import org.json.JSONObject;
//
//import java.io.File;
//import java.nio.file.Files;
//
//public class ValidateEmailJson {
//    public static void main(String[] args) {
//        try {
//            // Load the JSON schema from file
//            File schemaFile = new File("src/main/java/org/example/schema.json");
//            String schemaContent = new String(Files.readAllBytes(schemaFile.toPath()));
//            JSONObject rawSchema = new JSONObject(schemaContent);
//            Schema schema = SchemaLoader.load(rawSchema);
//
//            // Load the JSON data to validate
//            File jsonFile = new File("src/main/java/org/example/data2.json");
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode jsonNode = objectMapper.readTree(jsonFile);
////
//            // Convert the JSON node to JSONObject for schema validation
//            JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(jsonNode));
//
//            // Validate the JSON against the schema
//            schema.validate(jsonObject);
//            System.out.println("Valid JSON with a valid email format.");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Invalid JSON or email format.");
//        }
//    }
//}
//
