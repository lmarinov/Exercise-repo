package easterRaces.entities.racers;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.interfaces.Driver;
import easterRaces.entities.interfaces.Race;

import java.util.Collection;
import java.util.LinkedList;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.drivers = new LinkedList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null){
            throw new IllegalArgumentException(ExceptionMessages.DRIVER_INVALID);
        }else if (!driver.getCanParticipate()){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_PARTICIPATE, driver.getName()));
        }else if(this.getDrivers().contains(driver)){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_ALREADY_ADDED, driver.getName(), this.getName()));
        }

        this.drivers.add(driver);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() < 5){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < 1){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS, 1));
        }
        this.laps = laps;
    }
}
