package csv;
import java.io.*;
import java.util.*;
 class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", grade='" + grade + '\'' +
               '}';
    }
}


public class CSVToStudentList {
    public static void main(String[] args) {
        String inputFile = "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line = reader.readLine(); // Skip header

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1); // preserve empty fields
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());
                    String grade = parts[3].trim();

                    students.add(new Student(id, name, age, grade));
                }
            }

            // Print all students
            for (Student s : students) {
                System.out.println(s);
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
