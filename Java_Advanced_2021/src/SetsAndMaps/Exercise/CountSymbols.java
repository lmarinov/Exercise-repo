package SetsAndMaps.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> charOccurrences = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            charOccurrences.putIfAbsent(symbol, 0);
            charOccurrences.put(symbol, charOccurrences.get(symbol) + 1);
        }

//        charOccurrences.forEach((k, v) -> System.out.printf("%c: %d time/s%n", k, v));

        for (Map.Entry<Character, Integer> entry : charOccurrences.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();

            System.out.printf("%c: %d time/s%n", key, value);
        }
    }
}
