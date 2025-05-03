package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJsonJackson {
    public static void main(String[] args) {
        String json = "{\"name\":\"Alice\",\"email\":\"alice@example.com\"}";

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode node = mapper.readTree(json);
            System.out.println("Valid JSON structure.");
        } catch (Exception e) {
            System.out.println("Invalid JSON structure.");
        }
    }
}


