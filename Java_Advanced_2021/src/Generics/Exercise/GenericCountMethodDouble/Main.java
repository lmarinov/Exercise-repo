package Generics.Exercise.GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Count<Double> count = new Count<Double>();
        for (int i = 0; i < n; i++) {
            Double input = Double.parseDouble(scanner.nextLine());
            count.addValue(input);
        }

        Double toCompare = Double.parseDouble(scanner.nextLine());
        System.out.println(count.countGreaterElements(toCompare));
    }
}
