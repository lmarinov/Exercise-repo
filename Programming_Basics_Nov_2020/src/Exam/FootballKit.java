package Exam;

import java.util.Scanner;

public class FootballKit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double shirtPrice = Double.parseDouble(scanner.nextLine());
        double goal = Double.parseDouble(scanner.nextLine());

        double shortsPrice = shirtPrice * 0.75;
        double socksPrice = shortsPrice * 0.20;
        double bootsPrice = (shortsPrice + shirtPrice) * 2;
        double totalPrice = (shirtPrice + socksPrice + bootsPrice + shortsPrice) * 0.85;

        if(totalPrice >= goal) System.out.printf("Yes, he will earn the world-cup replica ball!%nHis sum is %.2f lv.", totalPrice);
        else System.out.printf("No, he will not earn the world-cup replica ball.%nHe needs %.2f lv. more.", goal - totalPrice);
    }
}
