package Polymorphism.Exercise.P02VehiclesExtension;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption){
        super.setFuelConsumption(fuelConsumption + 1.6);
    }

    @Override
    public void refuel(double fuelAmount ) {
       super.refuel(fuelAmount * 0.95);
    }
}
