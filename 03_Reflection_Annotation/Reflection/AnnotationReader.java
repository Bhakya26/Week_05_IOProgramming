package reflection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class Book {
    
}

public class AnnotationReader {
    public static vxoid main(String[] args) {
        Class<Book> bookClass = Book.class;

        if (bookClass.isAnnotationPresent(Author.class)) {
            Author author = bookClass.getAnnotation(Author.class);
            System.out.println("Author Name: " + author.name());
        } else {
            System.out.println("No Author annotation present.");
        }
    }
}

