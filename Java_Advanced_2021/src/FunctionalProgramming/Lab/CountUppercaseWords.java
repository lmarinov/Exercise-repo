package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        Predicate<String> startsWithUppercase = str -> str != null && !str.isEmpty() && Character.isUpperCase(str.charAt(0));

        List<String> entries = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(MyFunctions.startsWithUppercase)
                .collect(Collectors.toList());

        long counter = entries.size();
        System.out.println(counter);
        entries.forEach(System.out::println);
    }
}
