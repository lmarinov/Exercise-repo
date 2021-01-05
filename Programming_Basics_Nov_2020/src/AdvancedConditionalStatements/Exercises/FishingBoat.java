package AdvancedConditionalStatements.Exercises;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);


        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermenCount = Integer.parseInt(scanner.nextLine());
        double cost = 0.0;
        double result = 0.0;

        switch (season){
            case "Summer":
            case "Autumn":
                cost = 4200;
                break;
            case "Spring":
                cost = 3000;
                break;
            case "Winter":
                cost = 2600;
                break;
        }

        if (fishermenCount <= 6){
            cost *= 0.9;
        }else if (fishermenCount <= 11){
            cost *= 0.85;
        }else {
            cost *= 0.75;
        }

        if ((fishermenCount % 2 == 0) && (!season.equals("Autumn"))){
            cost *= 0.95;
        }

        result = budget - cost;
        if (result >= 0){
            System.out.printf("Yes! You have %.2f leva left.", result);
        }else {
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(result));
        }
    }
}
