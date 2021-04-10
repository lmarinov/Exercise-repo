package easterRaces.entities.cars;

public class SportsCar extends  BaseCar{
    private static final double SPORTS_CAR_CUBIC_CENTIMETERS = 3000.0;
    private static final int MIN_HORSE_POWER = 250;
    private static final int MAX_HORSE_POWER = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, SPORTS_CAR_CUBIC_CENTIMETERS, MIN_HORSE_POWER, MAX_HORSE_POWER);
    }

}
