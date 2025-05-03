package reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
}

 class DIContainer {

    private Map<Class<?>, Object> container = new HashMap<>();

    public <T> void register(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T instance = clazz.newInstance();
        container.put(clazz, instance);
    }

    public void injectDependencies(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = container.get(field.getType());
                if (dependency != null) {
                    field.set(object, dependency);
                }
            }
        }
    }
}

class Engine {
    public void start() {
        System.out.println("Engine started!");
    }
}

class Car {
    @Inject
    private Engine engine;

    public void drive() {
        if (engine != null) {
            engine.start();
            System.out.println("Car is driving!");
        } else {
            System.out.println("No engine found!");
        }
    }
}

public class VehicleII {
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();
        container.register(Engine.class);
        container.register(Car.class);

        Car car = new Car();
        container.injectDependencies(car);
        car.drive();
    }
}
