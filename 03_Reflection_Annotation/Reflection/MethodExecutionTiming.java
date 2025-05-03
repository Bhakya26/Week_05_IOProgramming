package reflection;

import java.lang.reflect.Method;

public class MethodExecutionTiming {

    public static void measureExecutionTime(Object object, String methodName, Class<?>... parameterTypes) throws Exception {
        Method method = object.getClass().getMethod(methodName, parameterTypes);

        long startTime = System.nanoTime();
        method.invoke(object);  // Method execution
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Execution time of " + methodName + ": " + duration + " nanoseconds");
    }

    public static void main(String[] args) throws Exception {
        class SampleClass {
            public void sampleMethod() {
                try {
                    Thread.sleep(500);  // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        SampleClass sample = new SampleClass();
        measureExecutionTime(sample, "sampleMethod");
    }
}
