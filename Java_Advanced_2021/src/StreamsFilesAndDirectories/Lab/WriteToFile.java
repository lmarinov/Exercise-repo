package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String path1 = "E:\\Programming\\Exercise-repo\\Java_study_materials\\Java_Advanced_2021\\4 - StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String path = "E:\\Programming\\Exercise-repo\\Java_study_materials\\Java_Advanced_2021\\4 - StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";
        FileInputStream inputStream = new FileInputStream(path1);
        FileOutputStream outputStream = new FileOutputStream(path);

        PrintWriter writer = new PrintWriter(outputStream);

        int singleByte = inputStream.read();

        Set<Character> punctuation = new HashSet<>();
        punctuation.add(',');
        punctuation.add('.');
        punctuation.add('!');
        punctuation.add('?');

        while (singleByte >= 0){
           char symbol = (char) singleByte;

           if (!punctuation.contains(symbol)){
               writer.print(symbol);
           }

            singleByte = inputStream.read();
        }

        inputStream.close();
        writer.close();
    }
}
