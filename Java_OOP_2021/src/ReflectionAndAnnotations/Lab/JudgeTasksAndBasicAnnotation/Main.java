package ReflectionAndAnnotations.Lab.JudgeTasksAndBasicAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//  Problem 1
//        Class<? super Reflection> baseClazz = clazz.getSuperclass();
//
//        System.out.println("class " + clazz.getName());
//        System.out.println("class " + baseClazz.getName());
//
//        Arrays.stream(clazz.getInterfaces())
//                .forEach(i -> System.out.println("interface " + i.getName()));

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sb = new StringBuilder();

        Arrays.stream(fields).filter(field -> {
            int modifiers = field.getModifiers();
            return !Modifier.isPrivate(modifiers);
        }).sorted(Comparator.comparing(Field::getName)).forEach(field -> sb.append(String.format("%s must be private!",
                field.getName()))
                .append(System.lineSeparator()));

        Arrays.stream(methods).filter(method -> {
            int modifiers = method.getModifiers();
            return method.getName().contains("get") && !Modifier.isPublic(modifiers);
        }).sorted(Comparator.comparing(Method::getName)).forEach(method -> sb.append(String.format("%s have to be public!",
                method.getName()))
        .append(System.lineSeparator()));

        Arrays.stream(methods).filter(method -> {
            int modifiers = method.getModifiers();
            return method.getName().contains("set") && !Modifier.isPrivate(modifiers);
        }).sorted(Comparator.comparing(Method::getName)).forEach(method -> sb.append(String.format("%s have to be private!",
                method.getName()))
                .append(System.lineSeparator()));

        System.out.println(sb.toString().trim());
//  Problem 2       try {
////            Constructor<Reflection> ctor =  clazz.getDeclaredConstructor();
////            Reflection reflection = ctor.newInstance();
////            System.out.println(reflection.toString());
//
//            Method[] declaredMethods = clazz.getDeclaredMethods();
//            Set<Method> getters = new TreeSet<>(new MethodComparator());
//            Set<Method> setters = new TreeSet<>(new MethodComparator());
//
//
//            for (Method m : declaredMethods) {
//                if (m.getName().contains("get")) {
//                    getters.add(m);
//                } else if (m.getName().contains("set")) {
//                    setters.add(m);
//                }
//            }
//
//            for (Method getter : getters) {
//                System.out.println(getter.getName() +
//                        " will return class "
//                        + getter.getReturnType().getName());
//            }
//
//            for (Method setter : setters) {
//                System.out.println(setter.getName() + " and will set field of class " + setter.getParameterTypes()[0].getName());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static class MethodComparator implements Comparator<Method> {

        @Override
        public int compare(Method o1, Method o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
