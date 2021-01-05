package PreExam;

import java.util.Scanner;

public class BeerAndChips {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double beerPrice = 1.20;
        String fanName = scan.nextLine();
        double budget = Double.parseDouble(scan.nextLine());
        double beerBottles = Double.parseDouble(scan.nextLine());
        double packetsOfCrisps = Double.parseDouble(scan.nextLine());
        double beerTotal = beerPrice * beerBottles;
        double priceOfCrisps = beerTotal* 0.45;
        double totalCrisps = Math.ceil(priceOfCrisps * packetsOfCrisps);
        double totalValue = beerTotal + totalCrisps;

        if (budget >= totalValue){
            System.out.printf("%s bought a snack and has %.2f leva left.", fanName, budget - totalValue);
        }else {
            System.out.printf("%s needs %.2f more leva!", fanName, totalValue - budget);
        }
    }
}
