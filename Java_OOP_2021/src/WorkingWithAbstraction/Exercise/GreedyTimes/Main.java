package WorkingWithAbstraction.Exercise.GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] items = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < items.length; i += 2) {
            String item = items[i];
            long quantity = Long.parseLong(items[i + 1]);

            if (item.length() == 3) {
                // add cash to bag
                bag.addCash(item, quantity);

            } else if (item.toLowerCase().endsWith("gem")) {
                // add gem to bag
                bag.addGems(item, quantity);

            } else if (item.toLowerCase().equals("gold")) {
                // add gold to bag
                bag.addGold(quantity);
            }
        }

        bag.printContent();
    }
}