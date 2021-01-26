package StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers {
    private static final String INPUT_PATH = "src\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputLineNumbers.txt";
    private static final String OUTPUT_PATH = "src\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            PrintWriter writer = new PrintWriter(OUTPUT_PATH);

           int number = 1;
           String line = reader.readLine();

            while (line != null){
                writer.println(String.format("%d. %s", number, line));
                number++;
                line = reader.readLine();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
