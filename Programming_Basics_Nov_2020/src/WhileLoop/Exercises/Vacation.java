package WhileLoop.Exercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double moneyNeeded = Double.parseDouble(scan.nextLine());
        double moneySaved = Double.parseDouble(scan.nextLine());
        int spendCounter = 0;
        int daysCounter = 0;
        boolean isSaved = false;

        while (!isSaved){
            String action = scan.nextLine();
            double cashFlow = Double.parseDouble(scan.nextLine());

            if (action.equals("spend")){
                if (moneySaved - cashFlow < 0){
                    moneySaved = 0;
                }else {
                    moneySaved -= cashFlow;
                }
                spendCounter++;
            }else if (action.equals("save")){
                moneySaved += cashFlow;
                spendCounter = 0;
                if (moneyNeeded <= moneySaved) isSaved = true;
            }

            daysCounter++;

            if (spendCounter == 5){
                System.out.printf("You can't save the money.%n%d", daysCounter);
                break;
            }
        }

        if (isSaved) System.out.printf("You saved the money for %d days.", daysCounter);
    }
}
