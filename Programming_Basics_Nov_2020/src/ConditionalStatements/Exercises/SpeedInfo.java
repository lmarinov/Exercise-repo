package ConditionalStatements.Exercises;

import java.util.Scanner;

public class SpeedInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double speed = Double.parseDouble(sc.nextLine());
        String message;
        if (speed <= 10){
            message = "slow";
        }else if (speed <= 50){
            message = "average";
        }else if (speed <= 150){
            message = "fast";
        }else if (speed <= 1000){
            message = "ultra fast";
        }else {
            message = "extremely fast";
        }

        System.out.printf("%s%n", message);
    }
}
