package DesignPatterns.Lab.P01Singleton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SingletonContainer {
    private static PopulationTracker tracker;
    private static Datastore datastore;
    private static Engine engine;
    private static CommandRepository commandRepository;
    private static boolean isInitialized = false;

    private SingletonContainer(){}

    public static PopulationTracker getTracker(){
        validateInitialization();
        return tracker;
    }


    private static void validateInitialization() {
        if (!isInitialized){
            throw new IllegalStateException("SingletonContainer not initialized call .init() first.");
        }
    }

    public static Datastore getDatastore(){
        return datastore;
    }

    public static CommandRepository getCommandRepository(){
        return commandRepository;
    }

    public static Engine getEngine(){
        return engine;
    }

    public static void init() {
        if (!isInitialized){
            isInitialized = true;
            tracker = PopulationTracker.getInstance();
            datastore = Datastore.getInstance();
            commandRepository = CommandRepository.getInstance();
            engine = Engine.getInstance(new BufferedReader(new InputStreamReader(System.in)),
                    new BufferedWriter(new OutputStreamWriter(System.out)));
        }
    }
}
