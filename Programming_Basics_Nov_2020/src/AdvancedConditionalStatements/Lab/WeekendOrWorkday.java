package AdvancedConditionalStatements.Lab;

import java.util.Scanner;

public class WeekendOrWorkday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();
        String message;
        if (day.matches("(?i)monday|(?i)tuesday|(?i)wednesday|(?i)thursday|(?i)friday") ){
            message = "Working day";
        }else if (day.matches("(?i)saturday|(?i)sunday")){
            message = "Weekend";
        }else {
            message = "Error";
        }

        System.out.println(message);
    }
}
