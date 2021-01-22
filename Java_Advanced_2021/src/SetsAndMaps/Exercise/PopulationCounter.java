package SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //  country     city   population
        Map<String, Map<String, Long>> populationInfo = new LinkedHashMap<>();

        String line = "";
        while (!"report".equals(line = scanner.nextLine())){
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            populationInfo.putIfAbsent(country, new LinkedHashMap<>());
            populationInfo.get(country).putIfAbsent(city, population);
        }

        populationInfo.entrySet().stream().sorted((c1, c2) -> {
            long p1 = c1.getValue().values().stream().mapToLong(x -> x).sum();
            long p2 = c2.getValue().values().stream().mapToLong(x -> x).sum();

            return Long.compare(p2, p1);
        }).forEach(c -> {
            long totalPopulation = c.getValue().values().stream().mapToLong(e -> e).sum();
            System.out.printf("%s (total population: %d)%n",c.getKey(), totalPopulation);
            Map<String, Long> citiInfo = c.getValue();
            citiInfo.entrySet().stream().sorted((c1, c2) -> Long.compare(c2.getValue(), c1.getValue()))
                    .forEach(s -> System.out.printf("=>%s: %d%n", s.getKey(), s.getValue()));
        });
    }
}
