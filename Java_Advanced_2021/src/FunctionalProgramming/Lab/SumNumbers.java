package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Function<String, IntStream> getIntStream = str -> {
            return Arrays.stream(str.split(", "))
                    .mapToInt(Integer::parseInt);
        };

        Function<String, Long> getCount = str -> getIntStream.apply(str)
                .count();

        Function<String, Integer> getSum = str -> getIntStream.apply(str)
                .sum();

        System.out.printf("Count = %d%nSum = %d", getCount.apply(input), getSum.apply(input));
    }

}
