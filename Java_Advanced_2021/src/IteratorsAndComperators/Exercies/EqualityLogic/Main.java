package IteratorsAndComperators.Exercies.EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<Person> treePeople = new TreeSet<>();
        Set<Person> hashPeople = new HashSet<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person currentPerson = new Person(name, age);
            treePeople.add(currentPerson);
            hashPeople.add(currentPerson);
        }

        System.out.println(treePeople.size());
        System.out.println(hashPeople.size());
    }
}
