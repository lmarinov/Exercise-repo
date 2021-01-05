package WhileLoop.Exercises;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        boolean isReached = false;
        int totalSteps = 0;

        while (totalSteps < 10000) {
            if (command.equals("Going home")){
                int steps = Integer.parseInt(scan.nextLine());
                totalSteps += steps;

                if (totalSteps >= 10000) isReached = true;
                break;
            }else {
                int steps = Integer.parseInt(command);
                totalSteps += steps;
                if (totalSteps >= 10000) { isReached = true; break; }
                command = scan.nextLine();
            }
        }

        if (isReached){
            System.out.printf("Goal reached! Good job!%n%d steps over the goal!", totalSteps - 10000);
        }else {
            System.out.printf("%d more steps to reach goal.", 10000 - totalSteps);
        }
    }
}