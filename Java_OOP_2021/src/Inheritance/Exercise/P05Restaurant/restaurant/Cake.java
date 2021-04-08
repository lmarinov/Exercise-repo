package Inheritance.Exercise.P05Restaurant.restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert{
    final static double CAKE_GRAMS = 250.0;
    final static double CAKE_CALORIES = 1000.0;
    final static BigDecimal CAKE_PRICE = BigDecimal.valueOf(5);

    public Cake(String name) {
        super(name,CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }
}
