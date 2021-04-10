package easterRaces.core;

import easterRaces.common.ExceptionMessages;
import easterRaces.common.OutputMessages;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.interfaces.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.interfaces.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.interfaces.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Race> raceRepository;
    private Repository<Car> carRepository;
    private Repository<Driver> driverRepository;

    public ControllerImpl(Repository<Driver> driverRepository,
                          Repository<Car> carRepository,
                          Repository<Race> raceRepository) {
        this.raceRepository = raceRepository;
        this.carRepository = carRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public String createDriver(String driverName) {
        Driver driver = new DriverImpl(driverName);

        if (this.driverRepository.getByName(driverName) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, driverName));
        }

        this.driverRepository.add(driver);

        return String.format(OutputMessages.DRIVER_CREATED, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car newCar = type.equals("Muscle")
                ? new MuscleCar(model, horsePower)
                : type.equals("Sports")
                ? new SportsCar(model, horsePower)
                : null;

        if (this.carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS, model));
        }

        assert newCar != null;
        this.carRepository.add(newCar);

        return String.format(OutputMessages.CAR_CREATED, newCar.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Car targetCar = this.carRepository.getByName(carModel);
        Driver targetDriver = this.driverRepository.getByName(driverName);

        if (targetDriver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        } else if (targetCar == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND, carModel));
        }

        targetDriver.addCar(targetCar);

        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Driver targetDriver = this.driverRepository.getByName(driverName);
        Race targetRace = this.raceRepository.getByName(raceName);

        if (targetRace == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        } else if (targetDriver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }

        targetRace.addDriver(targetDriver);

        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);

        if (this.raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, name));
        }

        this.raceRepository.add(race);

        return String.format(OutputMessages.RACE_CREATED, name);
    }

    @Override
    public String startRace(String raceName) {
        Race targetRace = this.raceRepository.getByName(raceName);

        if (targetRace == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        if (targetRace.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID, raceName, 3));
        }

        StringBuilder output = new StringBuilder();
        int laps = targetRace.getLaps();
        List<Driver> topThreeDrivers = targetRace.getDrivers().stream()
                .sorted((driver1, driver2) -> String.valueOf(driver2.getCar().calculateRacePoints(laps)).compareTo(String.valueOf(driver1.getCar().calculateRacePoints(laps))))
                .limit(3).collect(Collectors.toList());

        Driver first = topThreeDrivers.get(0);
        Driver second = topThreeDrivers.get(1);
        Driver third = topThreeDrivers.get(2);

        this.driverRepository.getByName(first.getName()).winRace();
        output.append(String.format(OutputMessages.DRIVER_FIRST_POSITION, first.getName(), raceName))
                .append(System.lineSeparator())
                .append(String.format(OutputMessages.DRIVER_SECOND_POSITION, second.getName(), raceName))
                .append(System.lineSeparator())
                .append(String.format(OutputMessages.DRIVER_THIRD_POSITION, third.getName(), raceName))
                .append(System.lineSeparator());

        return output.toString().trim();
    }
}
