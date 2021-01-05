package ConditionalStatements.Exercises;

import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        minutes +=15;
        if (minutes >= 60){
            hours +=1;
            minutes = minutes % 60;
        }

        if (hours > 23){
            hours = hours % 24;
        }

        if (minutes < 10){
            System.out.printf("%d:%02d%n", hours, minutes);
        }else {
            System.out.printf("%d:%d%n", hours, minutes);
        }

    }
}
