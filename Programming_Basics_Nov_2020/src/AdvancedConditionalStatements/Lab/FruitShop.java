package AdvancedConditionalStatements.Lab;

import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double price = 0.0;
        String message = "";

        switch (day){
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                switch (fruit){
                    case "apple":
                        price = 1.20;
                        break;
                    case "banana":
                        price = 2.50;
                        break;
                    case "grapefruit":
                        price = 1.45;
                        break;
                    case "grapes":
                        price = 3.85;
                        break;
                    case "kiwi":
                        price = 2.70;
                        break;
                    case "orange":
                        price = 0.85;
                        break;
                    case "pineapple":
                        price = 5.50;
                        break;
                    default:
                        message = "error";
                        break;
                }
                break;
            case "Saturday":
            case "Sunday":
                switch (fruit){
                    case "apple":
                        price = 1.25;
                        break;
                    case "banana":
                        price = 2.70;
                        break;
                    case "grapefruit":
                        price = 1.60;
                        break;
                    case "grapes":
                        price = 4.20;
                        break;
                    case "kiwi":
                        price = 3.00;
                        break;
                    case "orange":
                        price = 0.90;
                        break;
                    case "pineapple":
                        price = 5.60;
                        break;
                    default:
                        message = "error";
                        break;
                }
                break;
            default:
                message = "error";
                break;
        }

        if (message.equals("")){
            double value = price * quantity;
            System.out.printf("%.2f", value);
        }else {
            System.out.println(message);
        }
    }
}
