package Encapsulation.Exercise.P04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] pizzaTokens = scanner.nextLine().split("\\s+");
        String[] doughTokens = scanner.nextLine().split("\\s+");

        try {
            int countOfToppings = Integer.parseInt(pizzaTokens[2]);
            String pizzaType = pizzaTokens[1];

            Pizza pizza = new Pizza(pizzaType, countOfToppings);
            Dough dough = new Dough(doughTokens[1], doughTokens[2], Double.parseDouble(doughTokens[3]));
            pizza.setDough(dough);

            for (int i = 0; i < countOfToppings; i++) {
                String[] toppingTokens = scanner.nextLine().split("\\s+");
                Topping topping = new Topping(toppingTokens[1], Double.parseDouble(toppingTokens[2]));
                pizza.addTopping(topping);
            }

            System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
        }catch (IllegalStateException e){
            System.err.println(e.getMessage());
        }
    }
}
