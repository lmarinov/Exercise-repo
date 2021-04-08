package Abstraction.Exercise.P07CollectionHierarchy.models;

import Abstraction.Exercise.P07CollectionHierarchy.MyList;

public class MyListImpl extends Collection implements MyList {
    @Override
    public int getUsed() {
        return this.items.size();
    }

    @Override
    public String remove() {
        return this.items.remove(0);
    }

    @Override
    public int add(String input) {
        this.items.add(0, input);
        return 0;
    }
}
