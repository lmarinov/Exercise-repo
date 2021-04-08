package Polymorphism.Exercise.P02VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carTokens = scanner.nextLine().split("\\s+");
        String[] truckTokens = scanner.nextLine().split("\\s+");
        String[] busTokens = scanner.nextLine().split("\\s+");

        double carFuelQuantity = Double.parseDouble(carTokens[1]);
        double carFuelConsumption = Double.parseDouble(carTokens[2]);
        double carFuelCapacity = Double.parseDouble(carTokens[3]);
        double truckFuelQuantity = Double.parseDouble(truckTokens[1]);
        double truckFuelConsumption = Double.parseDouble(truckTokens[2]);
        double truckFuelCapacity = Double.parseDouble(truckTokens[3]);
        double busFuelQuantity = Double.parseDouble(busTokens[1]);
        double busFuelConsumption = Double.parseDouble(busTokens[2]);
        double busFuelCapacity = Double.parseDouble(busTokens[3]);

        Car car = new Car(carFuelQuantity, carFuelConsumption, carFuelCapacity);
        Truck truck = new Truck(truckFuelQuantity, truckFuelConsumption, truckFuelCapacity);
        Bus bus = new Bus(busFuelQuantity, busFuelConsumption, busFuelCapacity);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandTokens = scanner.nextLine().split("\\s+");
            String command = commandTokens[0];
            String vehicleType = commandTokens[1];
            double distanceOrRefuelAmount = Double.parseDouble(commandTokens[2]);

            try{
                switch (command) {
                    case "Drive":
                        if (vehicleType.equals("Car")) {
                            System.out.println(car.drive(distanceOrRefuelAmount));
                        } else if (vehicleType.equals("Bus")) {
                            System.out.println(bus.drive(distanceOrRefuelAmount));
                        } else {
                            System.out.println(truck.drive(distanceOrRefuelAmount));
                        }
                        break;
                    case "Refuel":
                        if (vehicleType.equals("Car")) {
                            car.refuel(distanceOrRefuelAmount);
                        } else if (vehicleType.equals("Bus")) {
                            bus.refuel(distanceOrRefuelAmount);
                        } else {
                            truck.refuel(distanceOrRefuelAmount);
                        }
                        break;
                    case "DriveEmpty":
                        bus.setIsEmpty(true);
                        System.out.println(bus.drive(distanceOrRefuelAmount));
                        bus.setIsEmpty(false);
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
