package reflection;

import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

public class PrivateFieldAccess {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);
            Class<?> personClass = person.getClass();
            Field ageField = personClass.getDeclaredField("age");
            ageField.setAccessible(true);
            int currentAge = (int) ageField.get(person);
            System.out.println("Original Age: " + currentAge);
            ageField.set(person, 35);
            int updatedAge = (int) ageField.get(person);
            System.out.println("Updated Age: " + updatedAge);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

