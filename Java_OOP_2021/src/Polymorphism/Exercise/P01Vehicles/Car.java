package Polymorphism.Exercise.P01Vehicles;

public class Car extends Vehicle{
    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption){
        super.setFuelConsumption(fuelConsumption + 0.9);
    }
}
