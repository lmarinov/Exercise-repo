package Exam;

import java.util.Scanner;

public class Workout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfTraining = Integer.parseInt(scanner.nextLine());
        double kilometersRanCurrentDay = Double.parseDouble(scanner.nextLine());
        double totalKilometersRun = kilometersRanCurrentDay;

        for (int i = 0; i < daysOfTraining; i++){
            double percentIncrease = Double.parseDouble(scanner.nextLine()) / 100;
            kilometersRanCurrentDay *= (1 + percentIncrease);
            totalKilometersRun += kilometersRanCurrentDay;
        }

        if (totalKilometersRun >= 1000) System.out.printf("You've done a great job running %.0f more kilometers!", Math.ceil(totalKilometersRun - 1000));
        else System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", Math.ceil(1000 - totalKilometersRun));
    }
}
