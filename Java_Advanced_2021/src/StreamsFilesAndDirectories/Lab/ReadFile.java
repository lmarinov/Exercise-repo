package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "E:\\Programming\\Exercise-repo\\Java_study_materials\\Java_Advanced_2021\\4 - StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        int singleByte = inputStream.read();

        while (singleByte >= 0){
            System.out.printf("%s ", Integer.toBinaryString(singleByte));

            singleByte = inputStream.read();
        }

        inputStream.close();
    }
}