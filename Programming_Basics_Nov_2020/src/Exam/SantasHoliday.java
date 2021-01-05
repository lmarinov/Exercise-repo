package Exam;

import java.util.Scanner;

public class SantasHoliday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfStay = Integer.parseInt(scanner.nextLine());
        int nights = daysOfStay - 1;
        String roomType = scanner.nextLine();
        String opinion = scanner.nextLine();
        double totalCost = 0.0;

        switch (roomType){
            case "room for one person":
                totalCost = 18.00 * nights;
                break;
            case "apartment":
                totalCost = nights * 25.00;
                if (daysOfStay <= 10) totalCost *= 0.70;
                else if (daysOfStay <= 15) totalCost *= 0.65;
                else totalCost *= 0.5;
                break;
            case "president apartment":
                totalCost = nights * 35.00;
                if (daysOfStay <= 10) totalCost *= 0.90;
                else if (daysOfStay <= 15) totalCost *= 0.85;
                else totalCost *= 0.80;
                break;
        }

        if (opinion.equals("positive")) totalCost *= 1.25;
        else totalCost *= 0.90;

        System.out.printf("%.2f", totalCost);
    }
}
