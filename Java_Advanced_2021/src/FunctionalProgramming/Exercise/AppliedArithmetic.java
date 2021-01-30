package FunctionalProgramming.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], int[]> addOne = arr -> Arrays.stream(arr)
                .map(x -> x+=1)
                .toArray();

        Function<int[], int[]> multiplyByTwo = arr -> Arrays.stream(arr)
                .map(x -> x *= 2)
                .toArray();

        Function<int[], int[]> subtractOne = arr -> Arrays.stream(arr)
                .map(x -> x -= 1)
                .toArray();


        String command = "";

        while (!"end".equals(command = scanner.nextLine())){
            switch (command){
                case "add":
                    numbers = addOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyByTwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractOne.apply(numbers);
                    break;
                case "print":
                    printNumbers.accept(numbers);
                    System.out.println();
                    break;
                default:
                    throw new IllegalStateException("Unknown command name " + command);
            }
        }
    }
    public static Consumer<int[]> printNumbers
            = x ->  Arrays.stream(x).forEach(n -> System.out.printf("%d ", n));
}
