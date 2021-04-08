package DesignPatterns.Exercise.command;

public class HeatingOnCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Here is so cold... heating on.");

    }
}
