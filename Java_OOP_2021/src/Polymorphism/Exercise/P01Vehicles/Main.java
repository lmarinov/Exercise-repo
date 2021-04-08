package Polymorphism.Exercise.P01Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carTokens = scanner.nextLine().split("\\s+");
        String[] truckTokens = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandTokens = scanner.nextLine().split("\\s+");
            String command = commandTokens[0];
            String vehicleType = commandTokens[1];
            double distanceOrRefuelAmount = Double.parseDouble(commandTokens[2]);

            if (command.equals("Drive")){
                if (vehicleType.equals("Car")){
                    System.out.println(car.drive(distanceOrRefuelAmount));
                }else{
                    System.out.println(truck.drive(distanceOrRefuelAmount));
                }
            }else if (command.equals("Refuel")){
                if (vehicleType.equals("Car")){
                    car.refuel(distanceOrRefuelAmount);
                }else{
                    truck.refuel(distanceOrRefuelAmount);
                }
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
