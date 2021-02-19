package SetsAndMaps.Lab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = "";
        Map<String, Map<String, Double>> shopProductLine = new TreeMap<>();

        while (!"Revision".equals(line = scanner.nextLine())){
            String[] tokens = line.split(", ");

            String shopName = tokens[0];
            String productName = tokens[1];
            Double pricePoint = Double.parseDouble(tokens[2]);

            shopProductLine.putIfAbsent(shopName, new LinkedHashMap<>());
            shopProductLine.get(shopName).put(productName, pricePoint);

        }

        for (Map.Entry<String, Map<String, Double>> shopEntry : shopProductLine.entrySet()) {
            String shopName = shopEntry.getKey();
            System.out.printf("%s->%n", shopName);

            for (Map.Entry<String, Double> productEntry : shopEntry.getValue().entrySet()) {
                String productName = productEntry.getKey();
                Double price = productEntry.getValue();

                System.out.printf("Product: %s, Price: %.1f%n", productName, price);
            }
        }
    }
}
