package easterRaces.repositories;

import easterRaces.entities.interfaces.Race;
import easterRaces.repositories.interfaces.Repository;

public class RaceRepository<T> extends RepositoryImpl<Race> implements Repository<Race> {
    public RaceRepository() {
        super();
    }

    @Override
    public Race getByName(String name) {
        return this.getAll().stream().filter(race -> race.getName().equals(name)).findFirst().orElse(null);
    }
}
