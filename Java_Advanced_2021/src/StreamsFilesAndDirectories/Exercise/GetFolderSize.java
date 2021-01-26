package StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class GetFolderSize {
    private static final String DIR_PATH = "src/StreamsFilesAndDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";
    private static final String OUTPUT_PATH = "src\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt";

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            File folder = new File(DIR_PATH);
            File[] files = folder.listFiles();
            long size = 0L;

            if (files != null) {
                for (File file : files) {
                    size += file.length();
                }
            }
            writer.printf("Folder size: %d", size);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
