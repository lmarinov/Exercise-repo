package StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class AllCapitals {
    private static final String INPUT_PATH = "src\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

    private static final String OUTPUT_PATH = "src\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
            PrintWriter writer = new PrintWriter(OUTPUT_PATH);
            String line = reader.readLine();
            while (line != null){
                writer.println(line.toUpperCase());
                line = reader.readLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
