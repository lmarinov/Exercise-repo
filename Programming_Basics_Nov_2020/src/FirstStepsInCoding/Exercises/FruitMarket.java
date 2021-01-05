package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Input quantities and price for strawberries
        double priceOfStrawberries = Double.parseDouble(scanner.nextLine());
        double bananaQuantity = Double.parseDouble(scanner.nextLine());
        double orangesQuantity = Double.parseDouble(scanner.nextLine());
        double blueberriesQuantity = Double.parseDouble(scanner.nextLine());
        double strawberriesQuantity = Double.parseDouble(scanner.nextLine());

//        Calculating the single price for each item
        double priceOfBlueberries = priceOfStrawberries/2;
        double priceOfOranges = priceOfBlueberries - (priceOfBlueberries * 40/100);
        double priceOfBananas = priceOfBlueberries - (priceOfBlueberries * 80/100);

//        Calculating sum needed to buy all items
        double blueberryValue = priceOfBlueberries * blueberriesQuantity;
        double bananaValue = priceOfBananas * bananaQuantity;
        double orangesValue = priceOfOranges * orangesQuantity;
        double strawberryValue = priceOfStrawberries * strawberriesQuantity;
        double totalExpense = blueberryValue + bananaValue + orangesValue + strawberryValue;

//        Printing sum
        System.out.printf("%.2f", totalExpense);

    }
}
