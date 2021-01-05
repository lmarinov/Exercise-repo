package NestedLoops.Exercises;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int primeSum = 0;
        int nonPrimeSum = 0;

        while (!command.equals("stop")){
            int number = Integer.parseInt(command);
            boolean isPrime = true;

            if(number < 0){
                System.out.println("Number is negative.");
                command = scanner.nextLine();
                continue;
            }

            for (int i = 2; i <= number / 2; i++){
                if (number % i == 0){
                    isPrime = false;
                    break;
                }
            }

            if (isPrime){
                primeSum += number;
            }else{
                nonPrimeSum += number;
            }

            command = scanner.nextLine();
        }

        System.out.println("Sum of all prime numbers is: " + primeSum);
        System.out.println("Sum of all non prime numbers is: " + nonPrimeSum);
    }
}
