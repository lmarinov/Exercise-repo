package ReflectionAndAnnotations.Exercise.barracksWars.core.commands;

import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.Inject;
import ReflectionAndAnnotations.Exercise.barracksWars.interfaces.Repository;

public class Report extends Command{
    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
       return this.repository.getStatistics();
    }
}
