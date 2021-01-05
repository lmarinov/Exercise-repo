package AdvancedConditionalStatements.Exercises;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        double result = 0.0;
        String evenOrOdd = "odd";

        switch (operator){
            case "+":
                result = firstNumber + secondNumber;
                if (result % 2 == 0){
                    evenOrOdd = "even";
                }
                System.out.printf("%d + %d = %.0f - %s", firstNumber, secondNumber, result, evenOrOdd);
                break;
            case "-":
                result = firstNumber - secondNumber;
                if (result % 2 == 0){
                    evenOrOdd = "even";
                }
                System.out.printf("%d - %d = %.0f - %s", firstNumber, secondNumber, result, evenOrOdd);
                break;
            case "*":
                result = firstNumber * secondNumber;
                if (result % 2 == 0){
                    evenOrOdd = "even";
                }
                System.out.printf("%d * %d = %.0f - %s", firstNumber, secondNumber, result, evenOrOdd);
                break;
            case "/":
                if (secondNumber == 0){
                    System.out.printf("Cannot divide %d by zero", firstNumber);
                    break;
                }
                result = (double) firstNumber / secondNumber;
                System.out.printf("%d / %d = %.2f", firstNumber, secondNumber, result);
                break;
            case "%":
                if (secondNumber == 0){
                    System.out.printf("Cannot divide %d by zero", firstNumber);
                    break;
                }
                result = firstNumber % secondNumber;
                System.out.printf("%d %% %d = %.0f", firstNumber, secondNumber, result);
                break;
        }

    }
}
