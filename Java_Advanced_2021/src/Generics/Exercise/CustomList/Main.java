package Generics.Exercise.CustomList;

import Generics.Exercise.CustomList.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;

        CustomList<String> customList = new CustomList<>();
        while (!"END".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String element = tokens[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    element = tokens[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    element = tokens[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
            }
        }
    }
}
