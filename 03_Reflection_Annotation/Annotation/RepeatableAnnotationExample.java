import java.lang.annotation.*;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}


class Project {

    @BugReport(description = "Null pointer exception on line 45")
    @BugReport(description = "Array index out of bounds when input is empty")
    public void processTask() {
        System.out.println("Processing task...");
    }
}


public class RepeatableAnnotationExample {
    public static void main(String[] args) throws Exception {
        Method method = Project.class.getMethod("processTask");

        if (method.isAnnotationPresent(BugReports.class) || method.isAnnotationPresent(BugReport.class)) {
            BugReport[] bugs = method.getAnnotationsByType(BugReport.class);
            for (int i = 0; i < bugs.length; i++) {
                System.out.println("BugReport " + (i + 1) + ": " + bugs[i].description());
            }
        }

        new Project().processTask();
    }
}
