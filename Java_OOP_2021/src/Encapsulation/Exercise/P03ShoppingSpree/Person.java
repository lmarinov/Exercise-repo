package Encapsulation.Exercise.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
//    -	name: String
//-	money:  double
//-	products:  List<Product>
    private String name;
    private double money;
    private List<Product> products;

//+ Person (String ,  double)

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

//-	setName (String) : void
//-	setMoney (double) : void

    private void setName(String name) {
        if (notEmpty(name)){
            this.name = name;
        }else{
            throw new IllegalStateException("Name cannot be empty");
        }
    }

    private void setMoney(double money) {
        if (nonNegative(money)){
            this.money = money;
        }else{
            throw new IllegalStateException("Money cannot be negative");
        }
    }

    public List<Product> getProducts(){
        return this.products;
    }

    //+	buyProduct (Product) : void
    public void buyProduct(Product product){
        if (this.money >= product.getCost()){
            this.products.add(product);
            this.money -= product.getCost();
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        }else{
            throw new IllegalStateException(String.format("%s can't afford %s%n", this.getName(), product.getName()));
        }
    }

    //+	getName(): String
    public String getName(){
        return this.name;
    }
    private boolean nonNegative(double money) {
        return money >= 0.0;
    }

    private boolean notEmpty(String name) {
        return name.trim().length() > 0;
    }
}
