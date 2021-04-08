package DesignPatterns.Exercise.command;

public class HeatingOffCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Here is so hot... heating off.");
    }
}
