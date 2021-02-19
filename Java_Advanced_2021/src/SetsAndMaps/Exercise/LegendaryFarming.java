package SetsAndMaps.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input;
        boolean needMoreFarm = true;
        Map<String, Integer> materials = new TreeMap<String, Integer>();
        Map<String, Integer> junk = new TreeMap<>();
        materials.putIfAbsent("shards", 0);
        materials.putIfAbsent("fragments", 0);
        materials.putIfAbsent("motes", 0);

        while (needMoreFarm) {
            input = scanner.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String materialName = input[i + 1].toLowerCase();

                if (materialName.equals("shards")
                        || materialName.equals("fragments")
                        || materialName.equals("motes")) {
                    materials.put(materialName, materials.get(materialName) + quantity);
                } else {
                    junk.putIfAbsent(materialName, 0);
                    junk.put(materialName, junk.get(materialName) + quantity);
                }

                if (materials.get(materialName) != null && materials.get(materialName) >= 250) {
                    i = input.length;
                    needMoreFarm = false;
                    materials.put(materialName, materials.get(materialName) - 250);
                    switch (materialName) {
                        case "shards":
                            System.out.println("Shadowmourne obtained!");
                            break;
                        case "fragments":
                            System.out.println("Valanyr obtained!");
                            break;
                        case "motes":
                            System.out.println("Dragonwrath obtained!");
                            break;
                    }
                }
            }
        }

        materials.entrySet()
                .stream()
                .sorted((c1, c2) -> Integer.compare(c2.getValue(), c1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> newValue, LinkedHashMap::new))
                .forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

        junk.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }
}
