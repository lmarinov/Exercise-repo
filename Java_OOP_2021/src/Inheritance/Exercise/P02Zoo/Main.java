package Inheritance.Exercise.P02Zoo;

public class Main {
    public static void main(String[] args) {
        Lizard liz = new Lizard("Lizard");
        Snake snake = new Snake("Snek");
        Gorilla gorilla = new Gorilla("Gorcho");
        Bear bear = new Bear("Whinney");

        System.out.println(liz.getName());
        System.out.println(snake.getName());
        System.out.println(gorilla.getName());
        System.out.println(bear.getName());
    }
}
