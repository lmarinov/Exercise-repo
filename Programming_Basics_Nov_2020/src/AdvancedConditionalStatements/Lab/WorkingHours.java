package AdvancedConditionalStatements.Lab;

import java.util.Scanner;

public class WorkingHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        String day = scanner.nextLine();

        if (day.matches("(?i)Monday|Tuesday|Wednesday|Thursday|Friday|Saturday") && hour >= 10 && hour <=18){
            System.out.println("open");
        }else {
            System.out.println("closed");
        }
    }
}
