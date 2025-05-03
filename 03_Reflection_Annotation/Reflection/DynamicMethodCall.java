package reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodCall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            System.out.print("Enter first integer: ");
            int a = scanner.nextInt();

            System.out.print("Enter second integer: ");
            int b = scanner.nextInt();

            Class<?> cls = MathOperations.class;
            Method method = cls.getMethod(methodName, int.class, int.class);
            Object obj = cls.getDeclaredConstructor().newInstance();
            Object result = method.invoke(obj, a, b);

            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
