package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> evenNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(MyFunctions.isEven)
                .collect(Collectors.toList());


        System.out.println(MyFunctions.formatList(evenNumbers));

        evenNumbers.sort(Comparator.comparingInt(x -> x));

        System.out.println(MyFunctions.formatList(evenNumbers));
    }
}
