package SetsAndMaps.Exercise;

import java.util.*;

public class UniqueNames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int namesCount = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueNames = new LinkedHashSet<>();

        for (int i = 0; i < namesCount; i++) {
            String name = scanner.nextLine();
            uniqueNames.add(name);
        }

        uniqueNames.forEach(System.out::println);
    }
}
