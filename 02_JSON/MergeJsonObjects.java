package org.example;

import com.google.gson.JsonObject;

public class MergeJsonObjects {
    public static void main(String[] args) {
        JsonObject obj1 = new JsonObject();
        obj1.addProperty("name", "Alice");
        obj1.addProperty("email", "alice@example.com");

        JsonObject obj2 = new JsonObject();
        obj2.addProperty("age", 30);
        obj2.addProperty("city", "New York");

        JsonObject merged = new JsonObject();
        obj1.entrySet().forEach(entry -> merged.add(entry.getKey(), entry.getValue()));
        obj2.entrySet().forEach(entry -> merged.add(entry.getKey(), entry.getValue()));

        System.out.println(merged.toString());
    }
}
