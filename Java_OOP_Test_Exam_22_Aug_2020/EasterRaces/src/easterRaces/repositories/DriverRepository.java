package easterRaces.repositories;

import easterRaces.entities.interfaces.Driver;
import easterRaces.repositories.interfaces.Repository;

public class DriverRepository<T> extends RepositoryImpl<Driver> implements Repository<Driver> {
    public DriverRepository() {
        super();
    }

    @Override
    public Driver getByName(String name) {
        return this.getAll().stream().filter(driver -> driver.getName().equals(name)).findFirst().orElse(null);
    }

}
