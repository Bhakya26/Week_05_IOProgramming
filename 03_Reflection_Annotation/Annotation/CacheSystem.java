import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class ComputationService {

    private static final Map<String, Integer> cache = new HashMap<>();

    @CacheResult
    public int expensiveComputation(int input) {
        String key = "computation_" + input;

        if (cache.containsKey(key)) {
            System.out.println("Returning cached result for input: " + input);
            return cache.get(key);
        }

        System.out.println("Computing result for input: " + input);
        int result = input * input;

        cache.put(key, result);

        return result;
    }
}

public class CacheSystem {

    public static void main(String[] args) throws Exception {
        ComputationService computationService = new ComputationService();
        Method method = ComputationService.class.getMethod("expensiveComputation", int.class);

        System.out.println("Result: " + computationService.expensiveComputation(5));
        System.out.println("Result: " + computationService.expensiveComputation(10));
        System.out.println("Result: " + computationService.expensiveComputation(5));
        System.out.println("Result: " + computationService.expensiveComputation(10));
    }
}
