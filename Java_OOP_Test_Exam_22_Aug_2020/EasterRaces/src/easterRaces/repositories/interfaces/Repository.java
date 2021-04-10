package easterRaces.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {
    void add(T model);

    boolean remove(T model);

    T getByName(String name);

    Collection<T> getAll();
}
