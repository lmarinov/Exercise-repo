package Inheritance.Exercise.P04NeedForSpeed;

public class Car extends Vehicle{

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        this.setFuelConsumption(3.0);
    }
}
