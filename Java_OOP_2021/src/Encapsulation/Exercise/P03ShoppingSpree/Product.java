package Encapsulation.Exercise.P03ShoppingSpree;

public class Product {
//    -	name: String
//-	cost: double
    private String name;
    private double cost;
//+ 	Product (String,  double)

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

//-	setCost (double): void
//-	setName (String): void
// + getName(): String
//+	getCost (): double

    public String getName() {
       return this.name;
    }

    private void setName(String name) {
        if (notEmpty(name)){
            this.name = name;
        }else{
            throw new IllegalStateException("Name cannot be empty");
        }
    }

    public double getCost() {
        return this.cost;
    }

    private void setCost(double cost) {
        if (nonNegative(cost)){
            this.cost = cost;
        }else{
            throw new IllegalStateException("Money cannot be negative");
        }
    }

    private boolean nonNegative(double cost) {
        return cost >= 0.0;
    }

    private boolean notEmpty(String name) {
        return name.trim().length() > 0;
    }


}
