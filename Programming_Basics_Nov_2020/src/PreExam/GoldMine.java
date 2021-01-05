package PreExam;

import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double locationCount = Double.parseDouble(scan.nextLine());

        for (int i = 0; i < locationCount; i++) {
            double averageGoldProductionEstimation = Double.parseDouble(scan.nextLine());
            int diggingDays = Integer.parseInt(scan.nextLine());
            double totalGoldProduced = 0.0;

            for (int j = 0; j < diggingDays; j++) {
                double goldDugPerDay = Double.parseDouble(scan.nextLine());
                double averageGoldProduction;
                totalGoldProduced += goldDugPerDay;

                if (j == diggingDays - 1) {
                    averageGoldProduction = totalGoldProduced / diggingDays;

                    if (averageGoldProductionEstimation <= averageGoldProduction) {
                        System.out.printf("Good job! Average gold per day: %.2f.%n", averageGoldProduction);
                    } else {
                        System.out.printf("You need %.2f gold.%n", averageGoldProductionEstimation - averageGoldProduction);
                    }
                }
            }
        }
    }
}

