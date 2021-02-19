package IteratorsAndComperators.Exercies.StrategyPattern;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getAge() - person2.getAge(); // or Integer.compare();
    }
}
