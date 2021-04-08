package Inheritance.Exercise.P05Restaurant.restaurant;

import java.math.BigDecimal;

public class Beverage extends Product{
    private double milliliters;

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.setMilliliters(milliliters);
    }

    public double getMilliliters() {
        return milliliters;
    }

    protected void setMilliliters(double milliliters) {
        this.milliliters = milliliters;
    }
}
