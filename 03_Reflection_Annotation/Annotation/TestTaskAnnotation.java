import java.lang.annotation.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}


class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Task completed!");
    }
}


public class TestTaskAnnotation{
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo task = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + task.priority());
            System.out.println("Assigned To: " + task.assignedTo());
        }

        new TaskManager().completeTask();
    }
}

