package ForLoop.Exercises;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int maxNumber = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int number = scan.nextInt();
            if (number > maxNumber) maxNumber = number;
            sum += number;
            if (i == n - 1) {
                int difference = 0;
                if (maxNumber == sum - maxNumber){ System.out.println("Yes\nSum = " + maxNumber); }
                else { difference = Math.abs(2 * maxNumber - sum); System.out.println("No\nDiff = " + difference);}
            }
        }
    }
}
