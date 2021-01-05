package PreExam;

import java.util.Scanner;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pastryType = scanner.nextLine();
        int numberOfOrders = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());
        double discount = 1;
        boolean extraAdded = false;
        double value = 0.0;
        double total = 0.0;

       switch (pastryType){
           case "Cake":
               if (day <= 15){
                   value = numberOfOrders * 24.00;
                   extraAdded = true;
               }else {
                   value = numberOfOrders * 28.70;

               }
               break;
           case "Souffle":
               if (day <= 15){
                   value = numberOfOrders * 6.66;
                   extraAdded = true;
               }else {
                   value = numberOfOrders * 9.80;
               }
               break;
           case "Baklava":
               if (day <= 15){
                   value = numberOfOrders * 12.60;
                   extraAdded = true;
               }else {
                   value = numberOfOrders * 16.98;
               }
               break;
       }

       if (day <= 22){
           if (value > 200){
               discount = 0.75;
           }else if ( value >= 100){
               discount = 0.85;
           }
       }

       if (extraAdded) total = (value * discount) * 0.90;
       else total = value * discount;

        System.out.printf("%.2f", total);
    }
}
