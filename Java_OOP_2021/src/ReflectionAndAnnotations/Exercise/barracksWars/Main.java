package ReflectionAndAnnotations.Exercise.barracksWars;

import ReflectionAndAnnotations.Exercise.barracksWars.core.CommandInterpreterImpl;
import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotations.Exercise.barracksWars.core.Engine;
import ReflectionAndAnnotations.Exercise.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotations.Exercise.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(new CommandInterpreterImpl(repository, unitFactory));
        engine.run();
    }
}
