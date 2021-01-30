package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> vatAdder = val -> val * 1.2;

        String[] values = Arrays.stream(scanner.nextLine().split(", "))
                .map(e -> String.format("%.2f", vatAdder.apply(Double.parseDouble(e))))
                .toArray(String[]::new);

       System.out.printf("Prices with VAT: %n%s", String.join("\n", values));
    }
}
