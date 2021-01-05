package Exam;

import java.util.Scanner;

public class Excursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleInGroup = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        int transportCards = Integer.parseInt(scanner.nextLine());
        int museumTickets = Integer.parseInt(scanner.nextLine());

        double transportExpenses = transportCards * peopleInGroup * 1.60;
        double museumExpenses = peopleInGroup * museumTickets * 6;
        double lodgingExpenses = peopleInGroup * nights * 20;
        double totalExpenses = (transportExpenses + museumExpenses + lodgingExpenses) * 1.25;

        System.out.printf("%.2f", totalExpenses);

    }
}
