package Inheritance.Exercise.P06Animals.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = "";
        List<Animal> animals = new ArrayList<>();

        while (!"Beast!".equals(command = scanner.nextLine())){
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens.length >= 3 ? tokens[2] : "";

            try {
                switch (command.trim()){
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        animals.add(cat);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(name, age);
                        animals.add(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name, age);
                        animals.add(tomcat);
                        break;
                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        animals.add(dog);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        animals.add(frog);
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        animals.forEach(System.out::println);
    }
}
