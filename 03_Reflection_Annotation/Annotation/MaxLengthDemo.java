import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength{
	int value();
}
class User{
	@MaxLength(10)
	private String username;
	public User(String username) {
        this.username = username;
        validateUsername();
    }

    private void validateUsername() {
        try {
            
            MaxLength maxLength = this.getClass().getDeclaredField("username").getAnnotation(MaxLength.class);
            if (maxLength != null && username.length() > maxLength.value()) {
                throw new IllegalArgumentException("Username exceeds maximum length of " + maxLength.value() + " characters.");
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}
public class MaxLengthDemo {
    public static void main(String[] args) {
        try {
            
            User user1 = new User("ValidUser");
            System.out.println("User created with username: " + user1.getUsername());

            User user2 = new User("VeryLongUsername");
            System.out.println("User created with username: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}