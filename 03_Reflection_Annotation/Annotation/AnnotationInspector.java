import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
 @interface ImportantMethod{
	String level() default "HIGH";
}
class TaskProcessor {
	@ImportantMethod(level="LOW")
	public void processData() {
		System.out.println("ProcessingData");
	}
	@ImportantMethod
		public void log(){
			System.out.println("LoggingActivity");
		}
		public void helperMEthod() {
			System.out.println("Helper method");
		}
	}
public class AnnotationInspector{
	public static void main(String[] args) {
		Class<TaskProcessor> cl=TaskProcessor.class;
		System.out.println("Annotated Methods in " + cl.getName() + ":\n");
		for(Method method:cl.getDeclaredMethods()) {
			if(method.isAnnotationPresent(ImportantMethod.class)) {
				ImportantMethod annotation=method.getAnnotation(ImportantMethod.class);
				System.out.println("MEthod name: "+method.getName()+ " LEvel: "+annotation.level());
				
			}
		}
		
	}
}

