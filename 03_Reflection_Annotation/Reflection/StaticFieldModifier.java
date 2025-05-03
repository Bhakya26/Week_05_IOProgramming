package reflection;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "ORIGINAL_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class StaticFieldModifier {
    public static void main(String[] args) {
        try {
            Class<?> configClass = Configuration.class;
            Field apiKeyField = configClass.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true);
            apiKeyField.set(null, "UPDATED_KEY");
            System.out.println("Modified API_KEY: " + Configuration.getApiKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

