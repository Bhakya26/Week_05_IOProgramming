
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class UserService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("Deleting user...");
    }

    @RoleAllowed("USER")
    public void viewUserProfile() {
        System.out.println("Viewing user profile...");
    }

    public void normalMethod() {
        System.out.println("This is a normal method that everyone can access.");
    }
}

public class RoleBasedAcessControl {

    public static void main(String[] args) throws Exception {
        String currentUserRole = "USER";

        UserService userService = new UserService();
        Class<?> clazz = userService.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                String requiredRole = roleAllowed.value();

                if (currentUserRole.equals(requiredRole)) {
                    System.out.println("Access granted to method: " + method.getName());
                    method.invoke(userService);
                } else {
                    System.out.println("Access Denied! You do not have the required role for method: " + method.getName());
                }
            } else {
                method.invoke(userService);
            }
        }
    }
}
