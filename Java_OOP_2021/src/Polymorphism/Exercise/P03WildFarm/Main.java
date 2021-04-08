package Polymorphism.Exercise.P03WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animalList = new ArrayList<>();

        String line = "";
        while (!"End".equals(line = scanner.nextLine())){
            String[] animalTokens = line.split("\\s+");
            String[] foodTokens = scanner.nextLine().split("\\s");

            String type = animalTokens[0];
            String name = animalTokens[1];
            double weight = Double.parseDouble(animalTokens[2]);
            String livingRegion = animalTokens[3];

            Animal animal = null;
            switch (type){
                case "Mouse":
                    animal = new Mouse(type, name, weight, livingRegion);
                    break;
                case "Tiger":
                    animal = new Tiger(type, name, weight, livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(type, name, weight, livingRegion);
                    break;
                case "Cat":
                    String breed = animalTokens[4];
                    animal = new Cat(type, name, weight, livingRegion, breed);
                    break;
            }

            assert animal != null;
            animal.makeSound();

            Food food;
            String foodType = foodTokens[0];
            int foodQuantity = Integer.parseInt(foodTokens[1]);
            if (foodType.equals("Vegetable")){
                food = new Vegetable(foodQuantity);
            }else{
                food = new Meat(foodQuantity);
            }

            try {
                animal.eat(food);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            animalList.add(animal);
        }

        animalList.forEach(System.out::println);
    }
}
