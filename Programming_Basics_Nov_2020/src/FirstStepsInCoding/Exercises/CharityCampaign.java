package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Read input from the console
        int days = Integer.parseInt(scanner.nextLine());
        int bakers = Integer.parseInt(scanner.nextLine());
        int cakes = Integer.parseInt(scanner.nextLine());
        int gaufrettes = Integer.parseInt(scanner.nextLine());
        int pancakes = Integer.parseInt(scanner.nextLine());

//        Monetary amount of each baked good produced
        double cakesValue = cakes * 45;
        double gaufrettesValue = gaufrettes * 5.80;
        double pancakesValue = pancakes * 3.20;

//        Calculating total value and amount of money collected
        double bakerRevenue = (cakesValue + gaufrettesValue + pancakesValue) * bakers;
        double totalRevenue = bakerRevenue * days;
        double profit = totalRevenue - totalRevenue/8;

//        Print result
        System.out.printf("%.2f", profit);
    }
}
