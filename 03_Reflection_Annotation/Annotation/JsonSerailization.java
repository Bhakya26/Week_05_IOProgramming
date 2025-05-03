import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();  // Custom JSON key
}

class Userr {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_email")
    private String email;

    public Userr(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

public class JsonSerailization{

    public static String convertToJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Map<String, String> jsonMap = new HashMap<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField jsonField = field.getAnnotation(JsonField.class);
                String jsonKey = jsonField.name();
                String value = String.valueOf(field.get(obj));
                jsonMap.put(jsonKey, value);
            }
        }

        StringBuilder jsonString = new StringBuilder("{");
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            jsonString.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
        }
        
        if (jsonString.length() > 1) {
            jsonString.delete(jsonString.length() - 2, jsonString.length());
        }
        
        jsonString.append("}");
        return jsonString.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        Userr user = new Userr("JohnDoe", 30, "john.doe@example.com");
        String json = convertToJson(user);
        System.out.println(json);
    }
}
