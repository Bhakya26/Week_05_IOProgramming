package org.example;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private String email;
    private int age;

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Age: " + age;
    }
}

public class FilterJsonByAge {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("src/main/java/org/example/ddata.json");
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            List<Person> filteredPeople = new ArrayList<>();

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject personObject = jsonArray.get(i).getAsJsonObject();
                int age = personObject.get("age").getAsInt();

                if (age > 25) {
                    String name = personObject.get("name").getAsString();
                    String email = personObject.get("email").getAsString();
                    filteredPeople.add(new Person(name, email, age));
                }
            }

            for (Person person : filteredPeople) {
                System.out.println(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

