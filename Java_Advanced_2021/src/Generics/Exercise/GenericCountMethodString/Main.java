package Generics.Exercise.GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Count<String> count = new Count<String>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            count.addValue(input);
        }

        String toCompare = scanner.nextLine();
        System.out.println(count.countGreaterElements(toCompare));
    }
}
