package DesignPatterns.Lab.P01Singleton;

public class EndCommand implements Command{
    @Override
    public String execute(String info) {
        return "Goodbye";
    }
}
