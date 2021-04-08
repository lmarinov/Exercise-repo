package DesignPatterns.Lab.P01Singleton;

import java.util.HashMap;
import java.util.Map;

public class CommandRepository {
    private Map<String, Command> commands;

    private CommandRepository() {
        this.commands = new HashMap<>();
    }

    public static CommandRepository instance;

    public static CommandRepository getInstance() {
        if (instance == null){
            instance = new CommandRepository();
        }
        return instance;
    }

    public void register(String commandName, Command command){
        this.commands.put(commandName, command);
    }

    public Command getCommand(String command){
        return this.commands.get(command);
    }
}
