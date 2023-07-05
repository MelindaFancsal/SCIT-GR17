package org.example.enumsAndAnnotations.annotationRuntime;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RunTestExample {

    public static void main(String[] args) {

        int passed = 0;
        Class<TestExample> obiect = TestExample.class;

        for (Method method : obiect.getDeclaredMethods()) {

            //verific daca avem anotarea @Test
            if (method.isAnnotationPresent(Test.class)) {
                Annotation annotation = method.getAnnotation(Test.class);
                Test test = (Test) annotation;

                if (test.enabled()) {

                    passed++;
                    System.out.println(method.getName());
                } else {
                    System.out.println(method.getName() + " not enabled");
                }

            }
        }
    }
}
