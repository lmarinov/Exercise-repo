package DefiningClasses.Exercise.SpeedRacing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());
        String line = "";
        Car car = new Car();

        while (n-- > 0){
            line = scanner.nextLine();
            String[] tokens = line.split("\\s+");
            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double fuelConsumption = Double.parseDouble(tokens[2]);
            car.add(model, new Car.CarInfo(fuel, fuelConsumption));
        }


        while (!"End".equals(line = scanner.nextLine())){
            String[] tokens = line.split("\\s+");
            if (tokens[0].equals("Drive")){
                if (car.getCars().containsKey(tokens[1])){
                    car.getCars().get(tokens[1]).drive(Integer.parseInt(tokens[2]));
                }
            }
        }

        car.getCars()
                .forEach((key, value) -> System.out.printf("%s %.2f %d%n", key, value.getFuelAmount(), value.getDistanceTraveled()));
    }
}
