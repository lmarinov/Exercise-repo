package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        List<Integer> numbers = new ArrayList<>();

        for (int i = n; i <= m; i++) {
            numbers.add(i);
        }

        String condition = scanner.nextLine();
        findEvenOrOdd(numbers, condition).forEach(num -> System.out.printf("%d ", num));

    }

    public static List<Integer> findEvenOrOdd(Collection<Integer> numbers, String numberType){
        switch (numberType){
            case "even":
                return numbers.stream()
                        .filter(filterEven)
                        .sorted()
                        .collect(Collectors.toList());
            case "odd":
                return numbers.stream()
                        .filter(filterOdd)
                        .sorted()
                        .collect(Collectors.toList());
            default:
                throw new IllegalStateException("Unknown type " + numberType);
        }
    }

    public static Predicate<Integer> filterOdd =
            n -> n % 2 != 0;

    public static Predicate<Integer> filterEven =
            n -> n % 2 == 0;
}
