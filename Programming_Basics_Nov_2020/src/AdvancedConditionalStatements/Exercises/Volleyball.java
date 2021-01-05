package AdvancedConditionalStatements.Exercises;

import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String yearType = scanner.nextLine();
        double numberOfVacationDays = Double.parseDouble(scanner.nextLine());
        double weekendsAtBirthCity = Double.parseDouble(scanner.nextLine());

        double weekendsAtSofia = 48 - weekendsAtBirthCity;
        double weekendsPlayedSofia = weekendsAtSofia * 3/4;
        double vacationsPlayed = numberOfVacationDays * 2/3;
        double totalDaysPlayed = weekendsPlayedSofia + vacationsPlayed + weekendsAtBirthCity;

        if (yearType.equals("leap")){
            totalDaysPlayed *= 1.15;
        }

        System.out.println((int) totalDaysPlayed);
    }
}
