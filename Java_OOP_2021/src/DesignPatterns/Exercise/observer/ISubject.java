package DesignPatterns.Exercise.observer;

public interface ISubject {
    void registerObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
    void changeState(String state);
}
