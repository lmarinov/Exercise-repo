package ReflectionAndAnnotations.Lab.CodingTracker;

import ReflectionAndAnnotations.Lab.JudgeTasksAndBasicAnnotation.Subject;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Class<MyMethods> clazz = MyMethods.class;

        Method[] methods = clazz.getDeclaredMethods();

        Map<String, List<Method>> methodByAuthors = new TreeMap<>();


        for (Method method : methods) {
            Author author = method.getAnnotation(Author.class);

            if (author != null) {
                methodByAuthors.putIfAbsent(author.name(), new LinkedList<>());
                methodByAuthors.get(author.name()).add(method);
            }
        }

        methodByAuthors.forEach((key, value) -> System.out.println(String.format("%s: %s",
                key,
                value.stream().map(method -> method.getName() + "()").collect(Collectors.joining(", ")))));
    }
}
