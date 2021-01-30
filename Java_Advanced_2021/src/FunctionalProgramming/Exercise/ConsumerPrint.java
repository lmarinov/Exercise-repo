package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s");

        printNames.accept(names);

    }

    public static Consumer<String[]> printNames = x -> {
        Arrays.stream(x).forEach(System.out::println);
    };
}
