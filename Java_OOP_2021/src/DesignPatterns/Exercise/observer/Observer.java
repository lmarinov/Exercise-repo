package DesignPatterns.Exercise.observer;

public class Observer implements IObserver {

    @Override
    public void update() {
        System.out.println("You've subscribed to this, now get spammed.");
    }
}
