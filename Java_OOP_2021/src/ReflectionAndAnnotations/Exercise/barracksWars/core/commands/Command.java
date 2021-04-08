package ReflectionAndAnnotations.Exercise.barracksWars.core.commands;

import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.Executable;

public abstract class Command implements Executable {
    private String[] data;

    public Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return data;
    }
}
