package AdvancedConditionalStatements.Exercises;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        double expenditure = 0.0;
        String destination = "";
        String lodging = "";

        switch (season){
            case "summer" :
                lodging = "Camp";
                if(budget <= 100){
                    expenditure = budget * 0.3;
                    destination = "Bulgaria";
                }else if (budget <= 1000){
                    expenditure = budget * 0.4;
                    destination = "Balkans";
                }else{
                    expenditure = budget * 0.9;
                    destination = "Europe";
                    lodging = "Hotel";
                }
                break;
            case "winter" :
                lodging = "Hotel";
                if(budget <= 100){
                    expenditure = budget * 0.7;
                    destination = "Bulgaria";
                }else if (budget <= 1000){
                    expenditure = budget * 0.8;
                    destination = "Balkans";
                }else{
                    expenditure = budget * 0.9;
                    destination = "Europe";
                }
                break;
        }

        System.out.printf("Somewhere in %s%n%s - %.2f", destination, lodging, expenditure);
    }
}
