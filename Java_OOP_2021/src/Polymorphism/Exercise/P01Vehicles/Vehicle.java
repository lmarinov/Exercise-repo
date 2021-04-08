package Polymorphism.Exercise.P01Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(Double fuelQuantity, Double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {
        double fuelNeed = distance * this.fuelConsumption;

        DecimalFormat df = new DecimalFormat("#.##");
        String result = String.format("%s needs refueling", this.getClass().getSimpleName());

        if (this.fuelQuantity >= fuelNeed) {
            this.fuelQuantity -= fuelNeed;
            result = String.format("%s travelled %s km",
                    this.getClass().getSimpleName(),
                    df.format(distance));
        }

        return result;
    }

    public void refuel(double fuelAmount) {
        this.fuelQuantity += fuelAmount;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.fuelQuantity);
    }
}
