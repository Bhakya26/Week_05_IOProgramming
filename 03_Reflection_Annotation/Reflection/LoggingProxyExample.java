package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
    void sayHello();
    void sayGoodbye();
}

class GreetingImpl implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }

    @Override
    public void sayGoodbye() {
        System.out.println("Goodbye!");
    }
}

class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method called: " + method.getName());
        return method.invoke(target, args);
    }
}

public class LoggingProxyExample {
    public static void main(String[] args) {
        // Create the target object (GreetingImpl)
        Greeting greeting = new GreetingImpl();

        // Create the dynamic proxy for Greeting
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class<?>[]{Greeting.class},
                new LoggingInvocationHandler(greeting)
        );

        // Invoke methods on the proxy
        proxy.sayHello();
        proxy.sayGoodbye();
    }
}

