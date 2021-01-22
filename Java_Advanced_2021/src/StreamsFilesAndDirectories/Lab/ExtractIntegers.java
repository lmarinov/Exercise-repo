package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path1 = "E:\\Programming\\Exercise-repo\\Java_study_materials\\Java_Advanced_2021\\4 - StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String path = "E:\\Programming\\Exercise-repo\\Java_study_materials\\Java_Advanced_2021\\4 - StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        FileInputStream inputStream = new FileInputStream(path1);

        Scanner scanner = new Scanner(inputStream);

        FileWriter outputWriter = new FileWriter(path);

        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                int number = scanner.nextInt();
                outputWriter.write(String.valueOf(number));
                outputWriter.write(System.lineSeparator());
            }else{
                scanner.next();
            }
        }

        outputWriter.flush();
        outputWriter.close();
    }
}
