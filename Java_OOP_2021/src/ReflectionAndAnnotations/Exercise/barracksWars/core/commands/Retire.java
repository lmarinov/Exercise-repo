package ReflectionAndAnnotations.Exercise.barracksWars.core.commands;

import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.Inject;
import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.Repository;

public class Retire extends Command{
    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        this.repository.removeUnit(unitType);
        return unitType + " retired!";
    }
}
