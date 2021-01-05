package ConditionalStatements.Exercises;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double budget = Double.parseDouble(sc.nextLine());
        int statistsQuantity = Integer.parseInt(sc.nextLine());
        double clothingPrice = Double.parseDouble(sc.nextLine());

        double decorValue = budget * 0.1;
        double clothingValue = statistsQuantity * clothingPrice;

        if (statistsQuantity > 150){
            clothingValue *= 0.9;
        }

        double remainingMoney = budget - (decorValue + clothingValue);

        if (remainingMoney < 0){
            System.out.printf("Not enough money!%nWingard needs %.2f leva more.", Math.abs(remainingMoney));
        }else {
            System.out.printf("Action!%nWingard starts filming with %.2f leva left.", Math.abs(remainingMoney));
        }
    }
}
