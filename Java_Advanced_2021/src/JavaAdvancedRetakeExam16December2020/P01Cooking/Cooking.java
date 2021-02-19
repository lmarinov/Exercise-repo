package JavaAdvancedRetakeExam16December2020.P01Cooking;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    private static Deque<Integer> liquids = new ArrayDeque<>();
    private static Deque<Integer> ingredients = new ArrayDeque<>();
    private static Map<String, Integer> productQuantities = new TreeMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(liquids::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::push);

        productQuantities.putIfAbsent("Bread", 0);
        productQuantities.putIfAbsent("Cake", 0);
        productQuantities.putIfAbsent("Pastry", 0);
        productQuantities.putIfAbsent("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()){
            int currentSum = liquids.peek() + ingredients.peek();

            switch (currentSum){
                case 25:
                    cookFood("Bread");
                    break;
                case 50:
                    cookFood("Cake");
                    break;
                case 75:
                    cookFood("Pastry");
                    break;
                case 100:
                    cookFood("Fruit Pie");
                    break;
                default:
                    liquids.poll();
                    ingredients.push(ingredients.pop() + 3);
                    break;
            }
        }

        if (allFoodIsCooked(productQuantities)){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything."); // they put 'to' twice is the solution... seriously
        }

        if (liquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else{
            System.out.printf("Liquids left: %s%n", liquids.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }

        if (ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        }else{
            System.out.printf("Ingredients left: %s%n", ingredients.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }

        productQuantities.entrySet().forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }

    private static boolean allFoodIsCooked(Map<String, Integer> productQuantities) {
        if (productQuantities.size() < 4){
            return false;
        }

        for (Map.Entry<String, Integer> quantity : productQuantities.entrySet()) {
            if (quantity.getValue() < 1){
                return false;
            }
        }

        return true;
    }

    private static void cookFood(String productName) {
        liquids.poll();
        ingredients.pop();
        productQuantities.put(productName, productQuantities.get(productName) + 1);
    }
}
