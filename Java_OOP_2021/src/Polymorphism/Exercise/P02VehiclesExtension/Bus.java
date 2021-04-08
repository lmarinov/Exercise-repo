package Polymorphism.Exercise.P02VehiclesExtension;

public class Bus extends Vehicle{
    private static final boolean DEFAULT_IS_EMPTY = false;
    private boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.setIsEmpty(DEFAULT_IS_EMPTY);
    }

    public void setIsEmpty(boolean isEmpty){
        this.isEmpty = isEmpty;
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        if (!this.isEmpty){
            super.setFuelConsumption(fuelConsumption + 1.4);
        }else{
            super.setFuelConsumption(fuelConsumption);
        }
    }
}
