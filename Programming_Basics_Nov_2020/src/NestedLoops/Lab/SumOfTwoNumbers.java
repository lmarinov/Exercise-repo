package NestedLoops.Lab;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());
        int comboCounter = 0;
        boolean isEqual = false;
        int sum = 0;
        int firstNum = 0;
        int secondNum = 0;

        for (int i = a; i <= b; i++){
            for (int j = a; j <= b; j++) {
                sum = i + j;
                comboCounter++;
                if (sum == c){
                    firstNum = i;
                    secondNum = j;
                    isEqual = true;
                    break;
                }
            }
            if (isEqual) break;
        }

        if (isEqual) System.out.printf("Combination N:%d (%d + %d = %d)",comboCounter, firstNum, secondNum, sum);
        else System.out.printf("%d combinations - neither equals %d", comboCounter, c);
    }
}
