package Polymorphism.Exercise.P02VehiclesExtension;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption){
        super.setFuelConsumption(fuelConsumption + 0.9);
    }
}
