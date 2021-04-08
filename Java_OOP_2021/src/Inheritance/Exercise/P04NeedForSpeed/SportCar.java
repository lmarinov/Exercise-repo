package Inheritance.Exercise.P04NeedForSpeed;

public class SportCar extends Car{
    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(10.0);
    }
}
