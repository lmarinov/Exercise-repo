package ForLoop.Lab;

import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = scan.nextInt();
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < count; i++){
            int number = scan.nextInt();

            if (number < minValue) minValue = number;
            if (number > maxValue) maxValue = number;
        }

        System.out.printf("Max number: %d%nMin number: %d", maxValue, minValue);
    }
}
