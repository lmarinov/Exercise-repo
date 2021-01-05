package ForLoop.Lab;

import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < 2*n; i++){
           if (i < n) leftSum += scan.nextInt();
           else rightSum += scan.nextInt();
        }

        if (rightSum == leftSum) System.out.println("Yes, sum = " + rightSum);
        else System.out.println("No, diff = " + Math.abs(rightSum - leftSum));
    }
}
