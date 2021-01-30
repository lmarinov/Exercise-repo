package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        Function<String, Person> parsePerson = str -> {
            String[] input = str.split(", ");
            return new Person(input[0], Integer.parseInt(input[1]));
        };

        while (n-- > 0){
            Person currentPerson = parsePerson.apply(scanner.nextLine());
            people.add(currentPerson);
        }

        String condition = scanner.nextLine();
        int ageCondition = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        people = condition.equals("older")
                ? Person.filterPeople(people, p -> p.age >= ageCondition)
                : Person.filterPeople(people, p -> p.age <= ageCondition);


        System.out.println(Person.formatPeople(people,
                getFormatter(format),
                System.lineSeparator()));
    }

    private static Function<Person, String> getFormatter(String format) {
        switch (format){
            case "name":
                return  p -> p.name;
            case "age":
                return p -> String.valueOf(p.age);
            case "name age":
                return p -> p.name + " - " + p.age;
            default:
                throw new IllegalStateException("Unknown format type " + format);
        }
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public static List<Person> filterPeople (Collection<Person> people,Predicate<Person> predicate){
            return people.stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
        }

        public static String formatPeople(Collection<Person> people, Function<Person, String> formatter, String delimiter){
            return people.stream()
                    .map(formatter)
                    .collect(Collectors.joining(delimiter));
        }
    }
}
