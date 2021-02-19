package SetsAndMaps.Exercise;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> usersDuration = new TreeMap<>();
        Map<String, Set<String>> userIp = new TreeMap<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String ip = tokens[0];
            String userName = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            usersDuration.putIfAbsent(userName, 0);
            usersDuration.put(userName, usersDuration.get(userName) + duration);
            userIp.putIfAbsent(userName, new TreeSet<>());
            userIp.get(userName).add(ip);
        }

        for (Map.Entry<String, Integer> person : usersDuration.entrySet()) {
            String name = person.getKey();
            System.out.printf("%s: %d [%s]%n", name
                    , person.getValue()
                    , String.join(", ", userIp.get(name)));
        }
    }
}
