package easterRaces.repositories;

import easterRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// Judge does not understand extending RepositoryImpl<T>

// Had to implement Repository<T> as java version 10 apparently only understands if it is implemented through an interface.

public abstract class RepositoryImpl<T> implements Repository<T> {
    private List<T> models;

    protected RepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public void add(T model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return this.models.remove(model);
    }

    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableList(this.models);
    }
}
