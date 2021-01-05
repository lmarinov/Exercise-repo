package AdvancedConditionalStatements.Lab;

import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        int price = 0;

        switch (day){
            case "Monday":
            case "Friday":
            case "Tuesday":
                price = 12;
                break;
            case "Wednesday":
            case "Thursday":
                price = 14;
                break;
            case "Saturday":
            case "Sunday":
                price = 16;
                break;
            default:
                break;
        }

        System.out.println(price);
    }
}
