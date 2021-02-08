package DefiningClasses.Exercise.RawData;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while(n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Tyre[] tyres = new Tyre[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            int count = 0;
            for (int i = 5; i < tokens.length; i+=2) {
                double tyrePressure = Double.parseDouble(tokens[i]);
                int tyreAge = Integer.parseInt(tokens[i + 1]);
                tyres[count++] = new Tyre(tyrePressure, tyreAge);
            }

            Car car = new Car(model, engine, cargo, tyres);
            cars.putIfAbsent(model, car);
        }

        String cargoType = scanner.nextLine();
        for (Car car : cars.values()) {
            if ("flamable".equals(cargoType)
                    && "flamable".equals(car.getCargo().getType())
                    && car.getEngine().getEnginePower() > 250){
                System.out.println(car);
            }else if("fragile".equals(cargoType)
                    && "fragile".equals(car.getCargo().getType())
                    && car.hasTyreWithLessPressureThanOne()){
                System.out.println(car);
            }
        }
    }
}
