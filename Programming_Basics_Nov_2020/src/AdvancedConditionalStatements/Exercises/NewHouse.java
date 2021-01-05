package AdvancedConditionalStatements.Exercises;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String flowerType = scanner.nextLine();
        int flowerQuantity = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double costs = 0.0;
        double price;
        double discount;

        switch (flowerType){
            case "Roses":
                price = 5;
                if (flowerQuantity > 80){
                    costs = (flowerQuantity * price);
                    discount = 0.1 * costs;
                    costs = costs - discount;
                }else {
                    costs = (flowerQuantity * price);
                }
                break;
            case "Dahlias":
                price = 3.80;
                if (flowerQuantity > 90){
                    costs = (flowerQuantity * price);
                    discount = 0.15 * costs;
                    costs = costs - discount;
                }else {
                    costs = (flowerQuantity * price);
                }
                break;
            case "Tulips":
                price = 2.80;
                if (flowerQuantity > 80){
                    costs = (flowerQuantity * price);
                    discount = 0.15 * costs;
                    costs = costs - discount;
                }else {
                    costs = (flowerQuantity * price);
                }
                break;
            case "Narcissus":
                price = 3;
                if (flowerQuantity < 120){
                    costs = (flowerQuantity * price);
                    discount = 0.15 * costs;
                    costs = costs + discount;
                }else {
                    costs = (flowerQuantity * price);
                }
                break;
            case "Gladiolus":
                price = 2.50;
                if (flowerQuantity < 80){
                    costs = (flowerQuantity * price);
                    discount = 0.20 * costs;
                    costs = costs + discount;
                }else {
                    costs = (flowerQuantity * price);
                }
                break;
        }

        double result = budget - costs;
        if (result >= 0){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowerQuantity, flowerType, result);
        }else{
            System.out.printf("Not enough money, you need %.2f leva more.", Math.abs(result));
        }
    }
}
