package DesignPatterns.Lab.P01Singleton;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.Writer;

public class Engine {
    private BufferedReader reader;
    private Writer writer;
    private boolean isRunning;
    private CommandRepository commands;

    private static Engine instance;

    private Engine(BufferedReader reader, Writer writer){
        this.reader = reader;
        this.writer = writer;
        this.commands = SingletonContainer.getCommandRepository();
    }

    public static Engine getInstance(BufferedReader reader, Writer writer) {
        if (instance == null){
            instance = new Engine(reader, writer);
        }
        return instance;
    }

    public void run(){
        this.isRunning = true;
        try{
            while (isRunning){
                String[] line = reader.readLine().split("=");
                String command = line[0];
                String info = "";

                if (!command.equals("End")) {
                    info = line[1];
                }

                String output = commands.getCommand(command).execute(info);
                writer.write(output + System.lineSeparator());
                writer.flush();
                isRunning = !output.equals("End");
            }
        }catch (Exception e){
            Logger.getGlobal().log(Level.SEVERE, e.getMessage());
        }

    }
}
