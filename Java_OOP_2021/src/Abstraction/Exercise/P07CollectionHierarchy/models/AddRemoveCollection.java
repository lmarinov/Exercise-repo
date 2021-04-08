package Abstraction.Exercise.P07CollectionHierarchy.models;

import Abstraction.Exercise.P07CollectionHierarchy.AddRemovable;

public class AddRemoveCollection extends Collection implements AddRemovable {
    @Override
    public String remove() {
        return this.items.remove(this.items.size() - 1);
    }

    @Override
    public int add(String input) {
        this.items.add(0, input);
        return 0;
    }
}
