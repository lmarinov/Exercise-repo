package SetsAndMaps.Exercise;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Dragon>> dragons = new LinkedHashMap<>();
        Map<String, Double> averageDamagePerType = new LinkedHashMap<>();
        Map<String, Double> averageHealthPerType = new LinkedHashMap<>();
        Map<String, Double> averageArmorPerType = new LinkedHashMap<>();

        String[] input;
        while (n-- > 0) {
            input = scanner.nextLine().split("\\s+");
            String dragonType = input[0];
            String dragonName = input[1];
            int dragonDamage = input[2].equals("null") ? 45 : Integer.parseInt(input[2]);
            int dragonHealth = input[3].equals("null") ? 250 : Integer.parseInt(input[3]);
            ;
            int dragonArmor = input[4].equals("null") ? 10 : Integer.parseInt(input[4]);
            ;

            dragons.putIfAbsent(dragonType, new TreeMap<>());

            dragons.get(dragonType).put(dragonName, new Dragon(dragonDamage, dragonHealth, dragonArmor));
            averageDamagePerType.putIfAbsent(dragonType, 0.0);
            averageDamagePerType.put(dragonType, dragons.get(dragonType).values().stream().mapToInt(Dragon::getDamage).average().orElse(0.0));
            averageHealthPerType.putIfAbsent(dragonType, 0.0);
            averageHealthPerType.put(dragonType, dragons.get(dragonType).values().stream().mapToInt(Dragon::getHealth).average().orElse(0.0));
            averageArmorPerType.putIfAbsent(dragonType, 0.0);
            averageArmorPerType.put(dragonType, dragons.get(dragonType).values().stream().mapToInt(Dragon::getArmor).average().orElse(0.0));
        }

        dragons.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + String.format("::(%.2f/%.2f/%.2f)",
                    averageDamagePerType.get(entry.getKey()),
                    averageHealthPerType.get(entry.getKey()),
                    averageArmorPerType.get(entry.getKey())));
            entry.getValue().forEach((key, value) -> System.out.printf("-%s -> %s%n", key, value));
        });

    }

    private static class Dragon {
        private Integer damage;
        private Integer health;
        private Integer armor;

        public Dragon(Integer damage, Integer health, Integer armor) {
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public Integer getDamage() {
            return damage;
        }

        public void setDamage(Integer damage) {
            this.damage = damage;
        }

        public Integer getHealth() {
            return health;
        }

        public void setHealth(Integer health) {
            this.health = health;
        }

        public Integer getArmor() {
            return armor;
        }

        public void setArmor(Integer armor) {
            this.armor = armor;
        }

        @Override
        public String toString() {
            return String.format("damage: %d, health: %d, armor: %d", this.getDamage(), this.getHealth(), this.getArmor());
        }
    }
}
