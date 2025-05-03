package reflection;

import java.lang.reflect.Constructor;

class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            Class<?> studentClass = Class.forName("Student");
            Constructor<?> constructor = studentClass.getDeclaredConstructor();
            Object studentObject = constructor.newInstance();
            Student student = (Student) studentObject;
            student.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
