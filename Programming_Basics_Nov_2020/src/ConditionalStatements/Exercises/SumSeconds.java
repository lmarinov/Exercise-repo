package ConditionalStatements.Exercises;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int timeFirst = Integer.parseInt(sc.nextLine());
        int timeSecond = Integer.parseInt(sc.nextLine());
        int timeThird = Integer.parseInt(sc.nextLine());

        int totalTime = timeFirst + timeSecond + timeThird;

        int minutes = totalTime / 60;
        int seconds = totalTime % 60;

        System.out.printf("%d:%02d", minutes, seconds);

    }
}
