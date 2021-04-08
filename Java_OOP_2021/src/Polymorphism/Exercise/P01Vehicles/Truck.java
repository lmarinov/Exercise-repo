package Polymorphism.Exercise.P01Vehicles;

public class Truck extends Vehicle{
    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
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
