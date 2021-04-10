package easterRaces.entities.cars;

public class MuscleCar extends BaseCar{
    private static final double MUSCLE_CAR_CUBIC_CENTIMETERS = 5000.0;
    private static final int MIN_HORSE_POWER = 400;
    private static final int MAX_HORSE_POWER = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, MUSCLE_CAR_CUBIC_CENTIMETERS, MIN_HORSE_POWER, MAX_HORSE_POWER);
    }
}
