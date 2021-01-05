package WhileLoop.Lab;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        double balance = 0.0;


        while (!command.equals("NoMoreMoney")){
           double input = Double.parseDouble(command);

           if(input < 0) {System.out.println("Invalid operation!"); break;}
           else balance += input;

            System.out.printf("Increase: %.2f%n", input);
            command = scan.nextLine();
        }

        System.out.printf("Total: %.2f", balance);
    }
}
