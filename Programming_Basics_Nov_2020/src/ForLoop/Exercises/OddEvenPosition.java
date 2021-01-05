package ForLoop.Exercises;

import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        double oddSum = 0;
        double evenSum = 0;
        double oddMin = Double.MAX_VALUE;
        double oddMax = -Double.MAX_VALUE;
        double evenMin = Double.MAX_VALUE;
        double evenMax = -Double.MAX_VALUE;

        for (int i = 1; i <= n; i++){
            double number = scan.nextDouble();
            if (i % 2 == 0){
                evenSum += number;
                if (number > evenMax){ evenMax = number;}
                if (number < evenMin) {evenMin = number;}
            }
            else {
                oddSum += number;
                if (number > oddMax){ oddMax = number;}
                if (number < oddMin) {oddMin = number;}
            }
        }
        System.out.printf("OddSum=%.2f,%n", oddSum);
        if (oddMin == Double.MAX_VALUE)System.out.print("OddMin=No,\n"); else System.out.printf("OddMin=%.2f,%n", oddMin);
        if (oddMax == -Double.MAX_VALUE)  System.out.print("OddMax=No,\n"); else System.out.printf("OddMax=%.2f,%n", oddMax);
        System.out.printf("EvenSum=%.2f,%n", evenSum);
        if (evenMin == Double.MAX_VALUE) System.out.print("EvenMin=No,\n"); else System.out.printf("EvenMin=%.2f,%n", evenMin);
        if (evenMax == -Double.MAX_VALUE) System.out.println("EvenMax=No"); else System.out.printf("EvenMax=%.2f", evenMax);
    }
}
