import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TodoAnnote{
	String task();
	String assignedto();
	String priority() default "MEDIUM";
}
class MethodProcessor{
	@TodoAnnote(task="Implement Login functionality",assignedto="Bhakya",priority="HIGH")
	public void login() {
		System.out.println("Login!!");
	}
	@TodoAnnote(task="Do search",assignedto="Tinbeer",priority="LOW")
	public void search() {
		System.out.println("Search feature");
	}
	@TodoAnnote(task="bug present checkout",assignedto="chloe")
	public void checkout() {
		System.out.println("Checkout functionality");
	}
	public void deploy() {
		System.out.println("Deploying application");
	}
}
public class ToDo {
	public static void main(String[] args) {
		Class<MethodProcessor> cl=MethodProcessor.class;
		System.out.println("Class name: "+cl.getName()+" indicating>>> pending tasks ");
		for(Method method: cl.getDeclaredMethods()) {
			if(method.isAnnotationPresent(TodoAnnote.class)) {
				TodoAnnote todo=method.getAnnotation(TodoAnnote.class);
				System.out.println("Method name: "+method.getName());
				System.out.println("Task name: "+todo.task());
				System.out.println("Task assigned to: "+todo.assignedto());
				System.out.println("Priority:  "+todo.priority());
				System.out.println();
			}
		}
	}

}
