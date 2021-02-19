package Generics.Lab.ArrayCreator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Integer[] arr = ArrayCreator.create(Integer.class, n, 13);

        Arrays.stream(arr).forEach(System.out::println);
    }
}
