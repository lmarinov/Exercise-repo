package DefiningClasses.Lab.CarInfo;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car (String brand){
        this(brand, "unknown", -1);
    }

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                this.getBrand(), this.getModel(), this.getHorsePower());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Car other = (Car) o;

        return this.brand.equals(other.brand)
                && this.model.equals(other.model)
                && this.horsePower == other.horsePower;
    }

    @Override
    public int hashCode() {
        return 73 * Objects.hash(brand, model, horsePower);
    }
}
