package ReflectionAndAnnotations.Exercise.barracksWars.core.commands;

import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.Inject;
import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.Unit;
import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.UnitFactory;

public class Add  extends Command{
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Add(String[] data){
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
