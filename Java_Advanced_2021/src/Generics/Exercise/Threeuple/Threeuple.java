package Generics.Exercise.Threeuple;

public class Threeuple<F, S, T>{
    private F firstValue;
    private S secondValue;
    private T thirdValue;

    public Threeuple(F firstValue, S secondValue, T thirdPanda) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdPanda;
    }

    public F getFirstValue() {
        return firstValue;
    }

    public S getSecondValue() {
        return secondValue;
    }

    public T getThirdValue() {
        return thirdValue;
    }

    public void setFirstValue(F firstValue) {
        this.firstValue = firstValue;
    }

    public void setSecondValue(S secondValue) {
        this.secondValue = secondValue;
    }

    public void setThirdValue(T thirdPanda) {
        this.thirdValue = thirdPanda;
    }

    @Override
    public String toString(){
        return String.format("%s -> %s -> %s", this.getFirstValue(), this.getSecondValue(), this.getThirdValue());
    }
}
