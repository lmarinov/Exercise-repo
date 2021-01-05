package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class YardGreening {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pricePerSqM = 7.61;
        double discount = 0.18;

//        Take input for square meters who will be greened
        double greenedArea = Double.parseDouble(scanner.nextLine());

//        Calculate final price and discount in leva
        double initialPrice = pricePerSqM * greenedArea;
        double discountValue = discount * initialPrice;
        double finalPrice = initialPrice - discountValue;

//        Print output final price and discount
        System.out.printf("The final price is: %.2f lv.\n", finalPrice);
        System.out.printf("The discount is: %.2f lv.", discountValue);

    }
}
