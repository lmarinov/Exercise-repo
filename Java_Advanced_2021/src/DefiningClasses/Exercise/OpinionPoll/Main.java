package DefiningClasses.Exercise.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream().filter(x -> x.getAge() > 30)
                .sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
                .forEach(x -> System.out.println(x.toString()));
    }
}
