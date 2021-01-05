package ConditionalStatements.Lab;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double vacationPrice = Double.parseDouble(sc.nextLine());
        double puzzles = Double.parseDouble(sc.nextLine());
        double dolls = Double.parseDouble(sc.nextLine());
        double bears = Double.parseDouble(sc.nextLine());
        double minions = Double.parseDouble(sc.nextLine());
        double trucks = Double.parseDouble(sc.nextLine());

        double total = (puzzles * 2.60) + (dolls * 3) +
                (bears * 4.10) + (minions * 8.20) + (trucks * 2);
        if (puzzles + dolls + bears + minions + trucks >= 50){
            total = total - (total * 0.25);
        }

        double result = total * 0.9;
        double profit = result - vacationPrice;
        if (profit >= 0){
            System.out.printf("Yes! %.2f lv left.", Math.abs(profit));
        }else {
            System.out.printf("Not enough money! %.2f lv needed.", Math.abs(profit));
        }
    }
}
