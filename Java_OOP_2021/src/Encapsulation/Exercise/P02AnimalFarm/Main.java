package Encapsulation.Exercise.P02AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());

            Chicken chicken = new Chicken(name, age);

            System.out.println(chicken);

        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
}
