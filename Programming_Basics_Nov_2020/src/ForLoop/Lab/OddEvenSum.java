package ForLoop.Lab;

import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < n; i++) if(i % 2 == 0) sumEven +=  scan.nextInt(); else sumOdd += scan.nextInt();
        if (sumEven == sumOdd) System.out.println("Yes\nSum = " + sumEven); else System.out.println("No\nDiff = " + Math.abs(sumEven - sumOdd));
    }
}
