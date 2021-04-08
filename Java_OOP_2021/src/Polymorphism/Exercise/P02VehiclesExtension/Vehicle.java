package Polymorphism.Exercise.P02VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }


    protected void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
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
        if (fuelAmount <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (this.tankCapacity >= this.fuelQuantity + fuelAmount) {
            this.fuelQuantity += fuelAmount;
        } else {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.fuelQuantity);
    }
}
