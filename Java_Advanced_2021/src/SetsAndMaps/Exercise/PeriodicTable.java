package SetsAndMaps.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> chemicalElements = new TreeSet<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");

            chemicalElements.addAll(Arrays.asList(tokens));
        }

        chemicalElements.forEach(s -> System.out.print(s + " "));
    }
}
