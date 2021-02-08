package DefiningClasses.Exercise.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Engine> engineMap = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine = null;
            if(tokens.length == 4){
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            }else if(tokens.length == 2){
                engine = new Engine(model, power);
            }else if(tokens.length == 3){
                if (tokens[2].matches("^\\d+$")){
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                }else{
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            }

            engineMap.put(model, engine);
        }

        List<Car> cars = new LinkedList<>();
        int m = Integer.parseInt(scanner.nextLine());
        while (m-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            Engine engine = engineMap.get(tokens[1]);
            Car car = null;
            if(tokens.length == 4){
              int weight = Integer.parseInt(tokens[2]);
              String color = tokens[3];
              car = new Car(model, engine, weight, color);
            }else if(tokens.length == 2){
                car = new Car(model, engine);
            }else if(tokens.length == 3){
                if (tokens[2].matches("^\\d+$")){
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                }else{
                    String color = tokens[2];
                    car = new Car(model, engine, color);
                }
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
