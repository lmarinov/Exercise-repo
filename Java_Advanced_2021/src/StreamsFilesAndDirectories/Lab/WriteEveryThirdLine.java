package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String fileName = "E:\\Programming\\Exercise-repo\\Java_study_materials\\Java_Advanced_2021\\4 - StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String destination = "E:\\Programming\\Exercise-repo\\Java_study_materials\\Java_Advanced_2021\\4 - StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

//        BufferedReader buffer = new BufferedReader(new FileReader(path1));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
//
//        String line = buffer.readLine();
//        int lineNumber = 1;
//
//        while (line != null){
//            lineNumber++;
//            line = buffer.readLine();
//
//            if (lineNumber % 3 == 0){
//                writer.write(line);
//                writer.newLine();
//            }
//        }
//
//        writer.close();

        List<String> strings =  Files.readAllLines(Path.of(fileName));

        List<String> lines = new ArrayList<>();

        for (int i = 2; i < strings.size(); i++) {
           lines.add(strings.get(i));
        }

        Files.write(Path.of(destination),
                lines, StandardCharsets.UTF_8);
    }
}
