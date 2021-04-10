package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.interfaces.Car;

public abstract class BaseCar implements Car {
    private String model;
    private int horsePower;
    private double cubicCentimeters;
    private final int MIN_HORSE_POWER;
    private final int MAX_HORSE_POWER;


    protected BaseCar(String model, int horsePower, double cubicCentimeters, int minHorsePower, int maxHorsePower) {
        this.setModel(model);
        MIN_HORSE_POWER = minHorsePower;
        MAX_HORSE_POWER = maxHorsePower;
        this.setHorsePower(horsePower);
        this.setCubicCentimeters(cubicCentimeters);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.getCubicCentimeters() / this.getHorsePower() * laps;
    }

    private void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.trim().length() < 4){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MODEL, model, 4));
        }
        this.model = model;
    }

    private void setHorsePower(int horsePower) {
        if (horsePower < MIN_HORSE_POWER || horsePower > MAX_HORSE_POWER){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }
        this.horsePower = horsePower;

    }

    private void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }
}
