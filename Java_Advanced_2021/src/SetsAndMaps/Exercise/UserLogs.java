package SetsAndMaps.Exercise;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // username ip     messagesCount
        Map<String, Map<String, Integer>> userInfo = new TreeMap<>();

        String line;

        while (!"end".equals(line = scanner.nextLine())) {

            String[] tokens = line.split("\\s+");
            String ip = tokens[0].split("=")[1];
            String userName = tokens[2].split("=")[1];

            Map<String, Integer> messagesCount = new LinkedHashMap<>();
            userInfo.putIfAbsent(userName, messagesCount);
            messagesCount = userInfo.get(userName);
            messagesCount.putIfAbsent(ip, 0);
            messagesCount.put(ip, messagesCount.get(ip) + 1);
        }

        for (Map.Entry<String, Map<String, Integer>> entry : userInfo.entrySet()) {
            System.out.println(entry.getKey() + ":");
            Map<String, Integer> innerMap = entry.getValue();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> innerEntry : innerMap.entrySet()) {
                String ipInfo = String.format("%s => %d", innerEntry.getKey(), innerEntry.getValue());
                sb.append(ipInfo)
                        .append(", ");
            }

            String res = sb.substring(0, sb.length() - 2);
            System.out.println(res + ".");
        }
    }
}
