package Inheritance.Exercise.P04NeedForSpeed;

public class Main {
    public static void main(String[] args) {
        SportCar sportCar = new SportCar(40, 50);
        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(30, 50);
        Car car = new Car(20, 50);
        raceMotorcycle.drive(2);
        sportCar.drive(4);
        car.drive(3);

        System.out.println(sportCar.getFuel());
        System.out.println(raceMotorcycle.getFuel());
        System.out.println(car.getFuel());
    }
}
