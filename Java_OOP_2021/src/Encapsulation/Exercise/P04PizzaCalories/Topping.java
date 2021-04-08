package Encapsulation.Exercise.P04PizzaCalories;

public class Topping {
//    -	toppingType: String
//-	weight: double

    private String toppingType;
    private double weight;

//+ 	Topping (String, double)

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

//-	setToppingType (String): void
//-	setWeight (double): void

    private void setToppingType(String toppingType) {
        if (!"Meat".equals(toppingType)
                && !"Veggies".equals(toppingType)
                && !"Cheese".equals(toppingType)
                && !"Sauce".equals(toppingType)){
            throw new IllegalStateException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50){
            throw new IllegalStateException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

//+	calculateCalories (): double

    public double calculateCalories(){
        return this.weight * 2 * this.getModifiersByToppingType(this.toppingType);
    }

    private double getModifiersByToppingType(String toppingType) {
        double modifier = 0.0;
        switch (toppingType){
            case "Meat":
                modifier = 1.2;
                break;
            case "Veggies":
                modifier = 0.8;
                break;
            case "Cheese":
                modifier = 1.1;
                break;
            case "Sauce":
                modifier = 0.9;
                break;
        }
        return modifier;
    }
}
