package AdvancedConditionalStatements.Exercises;

import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int hourOfExam = Integer.parseInt(scanner.nextLine());
        int minuteOfExam = Integer.parseInt(scanner.nextLine());
        int hourOfArrival = Integer.parseInt(scanner.nextLine());
        int minuteOfArrival = Integer.parseInt(scanner.nextLine());
        String message = "";
        int hoursDifference = 0;
        int minutesDifference = 0;

        minuteOfExam = hourOfExam * 60 + minuteOfExam;
        minuteOfArrival = hourOfArrival * 60 + minuteOfArrival;

        if (minuteOfArrival > minuteOfExam){
            message = "Late";
            hoursDifference = (minuteOfArrival - minuteOfExam) / 60;
            minutesDifference = (minuteOfArrival - minuteOfExam) % 60;
        }else if (minuteOfExam - minuteOfArrival > 30) {
            message = "Early";
            hoursDifference = (minuteOfExam - minuteOfArrival) / 60;
            minutesDifference = (minuteOfExam - minuteOfArrival) % 60;
        }else {
            message = "On time";
            hoursDifference = (minuteOfExam - minuteOfArrival) / 60;
            minutesDifference = (minuteOfExam - minuteOfArrival) % 60;
        }

        if (hoursDifference == 0 && minutesDifference == 0){
            System.out.println(message);
        } else if (hoursDifference == 0 && !(message.equals("Late"))){
            System.out.printf("%s%n%d minutes before the start", message, minutesDifference);
        }else if (hoursDifference == 0) {
            System.out.printf("%s%n%d minutes after the start", message, minutesDifference);
        }else if (!(message.equals("Late"))){
            System.out.printf("%s%n%d:%02d hours before the start", message, hoursDifference, minutesDifference);
        }else {
            System.out.printf("%s%n%d:%02d hours after the start", message, hoursDifference, minutesDifference);
        }
    }
}
