package Abstraction.Exercise.P07CollectionHierarchy.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    protected final int maxSize = 100;
    protected List<String> items;

    public Collection() {
        this.items = new ArrayList<>(maxSize);
    }
}
