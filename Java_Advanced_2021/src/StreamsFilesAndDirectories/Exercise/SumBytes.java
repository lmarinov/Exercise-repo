package StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    private static final String PATH = "src\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH));

            String line = reader.readLine();
            int  sum = 0;
            while (line != null){
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                line = reader.readLine();
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
