package AdvancedConditionalStatements.Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double price;
        double total = 0.0;

        switch (city) {
            case "Sofia":
                switch (product) {
                    case "coffee":
                        price = 0.50;
                        total = price * quantity;
                        break;
                    case "water":
                        price = 0.80;
                        total = price * quantity;
                        break;
                    case "beer":
                        price = 1.20;
                        total = price * quantity;
                        break;
                    case "sweets":
                        price = 1.45;
                        total = price * quantity;
                        break;
                    case "peanuts":
                        price = 1.60;
                        total = price * quantity;
                        break;
                    default:
                        break;
                }
                break;
            case "Plovdiv":
                switch (product) {
                    case "coffee":
                        price = 0.40;
                        total = price * quantity;
                        break;
                    case "water":
                        price = 0.70;
                        total = price * quantity;
                        break;
                    case "beer":
                        price = 1.15;
                        total = price * quantity;
                        break;
                    case "sweets":
                        price = 1.30;
                        total = price * quantity;
                        break;
                    case "peanuts":
                        price = 1.50;
                        total = price * quantity;
                        break;
                    default:
                        break;
                }
                break;
            case "Varna":
                switch (product) {
                    case "coffee":
                        price = 0.45;
                        total = price * quantity;
                        break;
                    case "water":
                        price = 0.70;
                        total = price * quantity;
                        break;
                    case "beer":
                        price = 1.10;
                        total = price * quantity;
                        break;
                    case "sweets":
                        price = 1.35;
                        total = price * quantity;
                        break;
                    case "peanuts":
                        price = 1.55;
                        total = price * quantity;
                        break;
                    default:
                        break;
                }
                break;
        }
        DecimalFormat df = new DecimalFormat("#0.####");
        System.out.println(df.format(total));
    }
}
