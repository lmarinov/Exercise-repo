package easterRaces.repositories;

import easterRaces.entities.interfaces.Car;
import easterRaces.repositories.interfaces.Repository;

public class CarRepository<T> extends RepositoryImpl<Car> implements Repository<Car> {
    public CarRepository() {
        super();
    }

    @Override
    public Car getByName(String model) {
        return this.getAll().stream().filter(car -> car.getModel().equals(model)).findFirst().orElse(null);
    }
}
