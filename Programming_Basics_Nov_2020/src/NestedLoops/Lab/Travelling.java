package NestedLoops.Lab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String destination = scan.nextLine();
        boolean hasEnded = false;

        while (!destination.equals("End")){
            double moneyNeeded = Double.parseDouble(scan.nextLine());
            double moneySaved;
            for (int i = 0; i < moneyNeeded; i += moneySaved){
                String input = scan.nextLine();
                if (input.equals("End")) { hasEnded = true; break; }
                moneySaved = Double.parseDouble(input);
            }
            if (hasEnded) break;
            System.out.printf("Going to %s!%n", destination);
            destination = scan.nextLine();
        }
    }
}