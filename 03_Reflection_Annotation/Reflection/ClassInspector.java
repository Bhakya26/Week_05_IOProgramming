package reflection;
import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInspector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter fully qualified class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();

        try {
            
            Class<?> cls = Class.forName(className);

            System.out.println("\nClass Name: " + cls.getName());

            
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("  " + constructor);
            }

            System.out.println("\nFields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("  " + field);
            }

            // Display Methods
            System.out.println("\nMethods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("  " + method);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        } catch (Exception e) {
            System.out.println("An error occurred while inspecting the class: " + e.getMessage());
        }

        scanner.close();
    }
}
