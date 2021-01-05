package ForLoop.Lab;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int years = scan.nextInt();
        double washingMachinePrice = scan.nextDouble();
        int toyPrice = scan.nextInt();
        int oddCount = 0;
        int money = 0;
        double total = 0;

        for (int i = 1; i <= years; i++){
            if (i % 2 == 0) money += (i/2) * 10 - 1; else oddCount++;
        }

        total = money + (toyPrice * oddCount);

        if (total >= washingMachinePrice) System.out.printf("Yes! %.2f", total - washingMachinePrice); else
            System.out.printf("No! %.2f", washingMachinePrice - total);
    }
}
