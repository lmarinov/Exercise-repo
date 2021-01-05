package AdvancedConditionalStatements.Lab;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfStay = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String rating = scanner.nextLine();
        double pricePerNight = 0.0;
        double discount = 0.0;
        double pricePerStay = 0.0;

        switch (roomType){
            case "room for one person":
                pricePerNight = 18.00;
                pricePerStay = (pricePerNight * (daysOfStay-1));
                break;
            case "apartment":
                if (daysOfStay < 10){
                    discount = 0.3;
                }else if (daysOfStay <= 15) {
                    discount = 0.35;
                }else {
                    discount = 0.5;
                }
                pricePerNight = 25.00;
                discount = (pricePerNight * (daysOfStay-1)) * discount;
                pricePerStay = pricePerNight * (daysOfStay-1) - discount;
                break;
            case "president apartment":
                if (daysOfStay < 10){
                    discount = 0.1;
                }else if (daysOfStay <= 15) {
                    discount = 0.15;
                }else {
                    discount = 0.2;
                }
                pricePerNight = 35.00;
                discount = (pricePerNight * (daysOfStay-1)) * discount;
                pricePerStay = pricePerNight * (daysOfStay-1) - discount;
                break;
            default:
                break;
        }

        if(rating.equals("positive")){
            double result = pricePerStay * 1.25;
            System.out.printf("%.2f", result);
        }else if (rating.equals("negative")){
            double result = pricePerStay * 0.90;
            System.out.printf("%.2f", result);
        }
    }
}
