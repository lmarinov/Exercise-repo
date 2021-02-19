package IteratorsAndComperators.Exercies.Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1)
                .collect(Collectors.toList());

        ListIterator listIterator = new ListIterator(data);

        String line = "";

        while (!"END".equals(line = scanner.nextLine())){
            switch (line){
                case "HasNext":
                    System.out.println(listIterator.iterator().hasNext());
                    break;
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "Print":
                    try {
                        listIterator.print();
                    } catch (IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    try {
                        listIterator.printAll();
                        System.out.println();
                    }catch (IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
            }
        }
    }
}
