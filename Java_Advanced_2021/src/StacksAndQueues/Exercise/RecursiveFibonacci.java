package StacksAndQueues.Exercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    private static long[] cache;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        cache = new long[n + 1];
        System.out.println(fibonacciWithBottomUpDP(n));

    }

    public static long getFibonacci(int n){
        if (n <= 1) return 1;
        else {
            long answer = getFibonacci(n - 1) + getFibonacci(n - 2);
            if (cache[n] == 0) {
                cache[n] = answer;
            }
            return cache[n];
        }
    }

    private static long fibonacciWithBottomUpDP(int n) {
        long[] fibonacciNumbers = new long[n + 1];

        fibonacciNumbers[0] = 1;
        fibonacciNumbers[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonacciNumbers[i] =
                    fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }

        return fibonacciNumbers[n];
    }

}
