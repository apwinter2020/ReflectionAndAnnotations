package Annotations;

import java.lang.annotation.*;
import java.util.ArrayList;

@Student(
        value="1399",
        name="CS_Math",
        age=10,
        names={"AP", "Class"}
)
@Student(
        value="1400",
        name="CS_Math",
        age=11,
        names={"AP", "Class"}
)
@SampleAnnotation
public class Main {
    @Student(
            value="1399",
            name="CS_Math",
            age=10,
            names={"AP", "Class"}
    )
    void a(){

    }

    public static void main(String[] args) {
        @SampleAnnotation int a;
        ArrayList<@SampleAnnotation String> b;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE})
@Inherited
@interface Students {
    Student[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.TYPE_USE, ElementType.METHOD})
@Inherited
@Repeatable(value = Students.class)
@interface Student {
    String   value();
    String   name() default "default name";
    int      age();
    String[] names();
}

@Target({ElementType.TYPE, ElementType.TYPE_USE})
@interface SampleAnnotation {
}
