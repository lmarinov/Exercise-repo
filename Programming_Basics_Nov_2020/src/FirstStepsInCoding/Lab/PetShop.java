package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double pricePerItemDogFood = 2.50;
        double pricePerItemOtherFood = 4;

//        Read input for dog count and count of other animals
        int dogCount = Integer.parseInt(scan.nextLine());
        int animalCount = Integer.parseInt(scan.nextLine());

//        Calculate monetary amount for dogs and other animals, as well as totals
        double dogFoodValue = pricePerItemDogFood * dogCount;
        double animalsFoodValue = pricePerItemOtherFood * animalCount;
        double totalValue = dogFoodValue + animalsFoodValue;

//        Print result
        System.out.printf("%.1f lv.", totalValue);
    }
}
