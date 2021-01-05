package Exam;

import java.util.Scanner;

public class Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int totalMetersClimbed = 5364;
        int daysClimbed = 1;
        boolean peakReached = false;

        while (!command.equals("END")){
            if (command.equals("Yes")) {
                daysClimbed++;

            }

            if (daysClimbed > 5) break;

            int metersClimbed = Integer.parseInt(scanner.nextLine());
            totalMetersClimbed += metersClimbed;

            if (totalMetersClimbed >= 8848) { peakReached = true; break; }
            command = scanner.nextLine();
        }

        if (peakReached) System.out.printf("Goal reached for %d days!", daysClimbed);
        else System.out.printf("Failed!%n%d", totalMetersClimbed);
    }
}
