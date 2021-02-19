package SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SrbskoUnleashed {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> venues = new LinkedHashMap<>();
        String input = "";

        while (!"End".equals(input = scanner.nextLine())){
            while (!validateInput(input)){
                input = scanner.nextLine();
            }

            String[] tokens = input.split(" @");
            String singerName = tokens[0];
            String[] venueInfo = tokens[1].split("\\s+");
            String venueName = "";
            int ticketPrice = 0;
            int seats = 0;

            if (venueInfo[1].matches("\\d+")){
                venueName = venueInfo[0];
                ticketPrice = Integer.parseInt(venueInfo[1]);
                seats = Integer.parseInt(venueInfo[2]);
            }else if(venueInfo[2].matches("\\d+")){
                venueName = venueInfo[0] + " " + venueInfo[1];
                ticketPrice = Integer.parseInt(venueInfo[2]);
                seats = Integer.parseInt(venueInfo[3]);
            }else{
                venueName = venueInfo[0] + " " + venueInfo[1] + " " + venueInfo[2];
                ticketPrice = Integer.parseInt(venueInfo[3]);
                seats = Integer.parseInt(venueInfo[4]);
            }

            venues.putIfAbsent(venueName, new LinkedHashMap<>());
            venues.get(venueName).putIfAbsent(singerName, 0);
            venues.get(venueName).put(singerName, venues.get(venueName).get(singerName) + ticketPrice * seats);
        }

        venues.forEach((key1, value1) -> {
            System.out.println(key1);
            value1
                    .entrySet()
                    .stream()
                    .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new))
                    .forEach((key, value) -> System.out.printf("#  %s -> %d%n", key, value));
        });

    }

    private static boolean validateInput(String input) {
        return input.matches("^[a-zA-Z]+[\\s]{0,1}?[a-zA-Z]+[\\s]{0,1}?[a-zA-Z]+[\\s][@][a-zA-Z]+[\\s]{0,1}?[a-zA-Z]+[\\s]{0,1}?[a-zA-Z]+[\\s][\\d]+[\\s][\\d]+");
    }
}