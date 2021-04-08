package Abstraction.Exercise.P07CollectionHierarchy.models;

import Abstraction.Exercise.P07CollectionHierarchy.Addable;

public class AddCollection extends Collection implements Addable {
    @Override
    public int add(String item) {
        this.items.add(item);
        return this.items.size() - 1;
    }
}
