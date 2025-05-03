import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++) {
            int x = i * i;
        }
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 1000000; i++) {
            int x = i * i;
        }
    }

    public void normalMethod() {
        for (int i = 0; i < 10000; i++) {
            int x = i * i;
        }
    }
}

public class LogExecutionTimedemo {
    public static void main(String[] args) throws Exception {
        PerformanceTest obj = new PerformanceTest();

        Class<?> clazz = PerformanceTest.class;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(obj);  
                long end = System.nanoTime();
                System.out.println("Method: " + method.getName() + " executed in " + (end - start) + " ns");
            }
        }
    }
}

