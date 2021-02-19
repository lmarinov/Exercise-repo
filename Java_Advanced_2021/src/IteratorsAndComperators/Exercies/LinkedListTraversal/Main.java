package IteratorsAndComperators.Exercies.LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedList numbers = new LinkedList();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            switch (command){
                case "Add":
                    numbers.add(number);
                    break;
                case "Remove":
                    numbers.remove(number);
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }

        System.out.println(numbers.getSize());
        numbers.forEach(e -> System.out.print(e + " "));
    }
}
