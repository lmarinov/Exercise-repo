package NestedLoops.Lab;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        double studentSeatsTaken = 0.0;
        double standardSeatsTaken = 0.0;
        double kidsSeatsTaken = 0.0;
        boolean isDone = false;

        while (!command.equals("Finish")){

            double emptySeats = Double.parseDouble(scanner.nextLine());
            double filmSeatsTaken = 0.0;

            for (int seatsTaken = 0; seatsTaken < emptySeats && emptySeats > 0; seatsTaken++){ // be careful with for loops!!
                String input = scanner.nextLine();
                if (input.equals("End")) break;
                else if (input.equals("Finish")) { isDone = true; break;}
                switch (input){
                    case "student":
                        studentSeatsTaken++;
                        break;
                    case "standard":
                        standardSeatsTaken++;
                        break;
                    case "kid":
                        kidsSeatsTaken++;
                        break;
                }
                filmSeatsTaken++;

            }
            double percent = filmSeatsTaken * 100.0 / emptySeats;
            System.out.printf("%s - %.2f%% full.%n", command, percent);
            if (isDone) break;
            command = scanner.nextLine();
        }

        double totalSeatsTaken = kidsSeatsTaken + standardSeatsTaken + studentSeatsTaken;
        System.out.printf("Total tickets: %.0f%n", totalSeatsTaken);
        double studentPercent = (studentSeatsTaken / totalSeatsTaken) * 100;
        System.out.printf("%.2f%% %s tickets.%n", studentPercent, "student");
        double standardPercent = (standardSeatsTaken / totalSeatsTaken) * 100;
        System.out.printf("%.2f%% %s tickets.%n", standardPercent, "standard");
        double kidsPercent = (kidsSeatsTaken / totalSeatsTaken) * 100;
        System.out.printf("%.2f%% %s tickets.", kidsPercent, "kids");
    }
}