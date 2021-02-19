package IteratorsAndComperators.Exercies.StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<Person> peopleByName = new TreeSet<>(new ComparatorByName());
        Set<Person> peopleByAge = new TreeSet<>(new ComparatorByAge());

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            Person person = new Person(Integer.parseInt(tokens[1]), tokens[0]);
            peopleByName.add(person);
            peopleByAge.add(person);
        }

        peopleByName.forEach(System.out::println);
        peopleByAge.forEach(System.out::println);
    }
}
