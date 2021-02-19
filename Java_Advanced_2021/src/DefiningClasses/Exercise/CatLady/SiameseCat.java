package DefiningClasses.Exercise.CatLady;

public class SiameseCat extends Cat{
    private double earSize;

    public SiameseCat(String name) {
        super(name);
        this.earSize = 0;
    }

    public SiameseCat(String name, double earSize){
        super(name);
        this.earSize = earSize;
    }

    public double getEarSize() {
        return earSize;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", this.getName(), this.getEarSize());
    }
}
