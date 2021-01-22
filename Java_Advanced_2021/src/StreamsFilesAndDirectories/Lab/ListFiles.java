package StreamsFilesAndDirectories.Lab;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        String fileName = "E:\\Programming\\Exercise-repo\\Java_study_materials\\Java_Advanced_2021\\4 - StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File files = new File(fileName);

        File[] innerFiles = files.listFiles();

        for (File innerFile : innerFiles) {
            if(!innerFile.isDirectory()){
                System.out.printf("%s: [%d]%n", innerFile.getName(), innerFile.length());
            }
        }
    }
}
