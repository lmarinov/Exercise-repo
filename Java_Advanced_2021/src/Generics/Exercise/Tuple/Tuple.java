package Generics.Exercise.Tuple;

public class Tuple<K,V>{
    private K firstElement;
    private V secondElement;

    public Tuple(K firstElement, V secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public K getFirstElement() {
        return firstElement;
    }

    public V getSecondElement() {
        return secondElement;
    }

    public void setFirstElement(K firstElement) {
        this.firstElement = firstElement;
    }

    public void setSecondElement(V secondElement) {
        this.secondElement = secondElement;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.getFirstElement(), this.getSecondElement());
    }
}
