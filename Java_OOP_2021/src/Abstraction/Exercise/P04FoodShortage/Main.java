package Abstraction.Exercise.P04FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Buyer> buyers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String idOrGroup = tokens[2];
            Buyer buyer = null;

            if (tokens.length == 4){
                String birthDate = tokens[3];
                buyer = new Citizen(name, age, idOrGroup,birthDate);
            }else if (tokens.length == 3){
                buyer = new Rebel(name, age, idOrGroup);
            }else{
                throw new IllegalArgumentException("Wrong parameter count.");
            }

            buyers.add(buyer);
        }

        String name = "";
        int totalFoodPurchased = 0;

        while (!"End".equals(name = scanner.nextLine())){
            for (Buyer buyer : buyers) {
                if (name.equals(buyer.getName())){
                    buyer.buyFood();

                    if (buyer instanceof Citizen){
                        totalFoodPurchased += 10;
                    }else{
                        totalFoodPurchased += 5;
                    }

                    break;
                }
            }
        }

        System.out.println(totalFoodPurchased);
    }
}
