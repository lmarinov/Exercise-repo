package DesignPatterns.Exercise.factory;

public class PizzaFactory {
    public Pizza createPizza(PizzaType type, int diameter) {
        Pizza pizza;

        switch (type) {
            case ITALIAN:
                pizza = new ItalianPizza(diameter);
                break;
            case CHEESE:
                pizza = new CheesePizza(diameter);
                break;
            case MEAT:
                pizza = new MeatPizza(diameter);
                break;
            default:
                throw new IllegalStateException("No such pizza type on offer.");
        }

        return pizza;
    }
}
