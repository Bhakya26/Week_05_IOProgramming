package reflection;
import java.lang.reflect.Field;

public class JsonConvertor {

    public static String toJson(Object obj) {
        if (obj == null) return "null";

        Class<?> cls = obj.getClass();
        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                json.append("\"").append(field.getName()).append("\": ");
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
            } catch (IllegalAccessException e) {
                json.append("\"").append(field.getName()).append("\": null");
            }
            if (i < fields.length - 1) {
                json.append(", ");
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        class Product {
            private String name;
            private double price;
            private int stock;

            public Product(String name, double price, int stock) {
                this.name = name;
                this.price = price;
                this.stock = stock;
            }
        }

        // Create a Product object
        Product product = new Product("Laptop", 999.99, 5);

        // Convert the Product object to a JSON-like string
        String json = JsonConvertor.toJson(product);
        System.out.println(json);
    }
}
