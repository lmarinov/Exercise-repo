package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//      Read inputs
        double deposit = Double.parseDouble(scanner.nextLine());
        int term = Integer.parseInt(scanner.nextLine());
        double interest = Double.parseDouble(scanner.nextLine());

//      Calculate sum at the end of deposit period
        double sum = deposit  + term * ((deposit * (interest/100)) / 12);

//      Print result
        System.out.printf("%.2f", sum);
    }
}
