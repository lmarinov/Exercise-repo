package StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class CountCharacterTypes {
    private static final String INPUT_PATH = "src\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

    private static final String OUTPUT_PATH = "src\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
            PrintWriter writer = new PrintWriter(OUTPUT_PATH);

            Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
            Set<Character> punctuationMarks = Set.of('!', '.', ',', '?');
            String line = reader.readLine();
            int vowelCounter = 0;
            int consonantsCounter = 0;
            int punctuationCounter = 0;

            while (line != null){
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    if (vowels.contains(symbol)){
                        vowelCounter++;
                    }else if (punctuationMarks.contains(symbol)){
                        punctuationCounter++;
                    }else if(symbol != ' '){
                        consonantsCounter++;
                    }
                }
                line = reader.readLine();
            }

            writer.println(String.format("Vowels: %d%nConsonants: %s%nPunctuation: %d", vowelCounter, consonantsCounter, punctuationCounter));
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
