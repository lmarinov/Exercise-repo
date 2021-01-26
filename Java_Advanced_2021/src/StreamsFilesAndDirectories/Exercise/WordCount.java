package StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    private static final String WORDS_INPUT_PATH = "src/StreamsFilesAndDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";
    private static final String TEXT_INPUT_PATH = "src/StreamsFilesAndDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";
    private static final String OUTPUT_PATH = "src\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt";

    public static void main(String[] args) {
        try (BufferedReader wordReader = new BufferedReader(new FileReader(WORDS_INPUT_PATH))) {
            BufferedReader textReader = new BufferedReader(new FileReader(TEXT_INPUT_PATH));
            PrintWriter writer = new PrintWriter(OUTPUT_PATH);
            String[] words = wordReader.readLine().split("\\s+");
            Map<String, Integer> wordOccurrences = new HashMap<>();
            for (String word : words) {
                wordOccurrences.put(word, 0);
            }

            String[] text = textReader.readLine().split("\\s+");
            for (String word : text) {
                if (wordOccurrences.containsKey(word)) {
                    wordOccurrences.put(word, wordOccurrences.get(word) + 1);
                }
            }
            wordOccurrences.entrySet()
                    .stream()
                    .sorted((w1, w2) -> w2.getValue()
                            .compareTo(w1.getValue()))
                    .forEach(n -> writer.println(String.format("%s - %d", n.getKey(), n.getValue())));

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
