package ConditionalStatements.Exercises;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double currentRecord = Double.parseDouble(sc.nextLine());
        double distanceInMeters = Double.parseDouble(sc.nextLine());
        double timePerMeter = Double.parseDouble(sc.nextLine());

        double slowDownCount = Math.floor(distanceInMeters / 15);
        double slowDownTime = slowDownCount * 12.5;
        double personalTime = distanceInMeters * timePerMeter + slowDownTime;

        if (currentRecord <= personalTime){
            double difference = personalTime - currentRecord;

            System.out.printf("No, he failed! He was %.2f seconds slower.%n", difference);
        }else {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.%n", personalTime);
        }
    }
}
