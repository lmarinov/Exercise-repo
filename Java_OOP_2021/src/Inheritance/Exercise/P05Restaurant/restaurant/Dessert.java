package Inheritance.Exercise.P05Restaurant.restaurant;

import java.math.BigDecimal;

public class Dessert extends Food{
    private double calories;

    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.setCalories(calories);
    }

    public double getCalories() {
        return calories;
    }

    protected void setCalories(double calories) {
        this.calories = calories;
    }
}
