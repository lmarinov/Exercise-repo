package StreamsFilesAndDirectories.Lab;

import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "E:\\Programming\\Exercise-repo\\Java_study_materials\\Java_Advanced_2021\\4 - StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "E:\\Programming\\Exercise-repo\\Java_study_materials\\Java_Advanced_2021\\4 - StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        FileInputStream inputBuffer = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputBuffer));

        int singleByte;
        FileWriter writer = new FileWriter(output);

        while ((singleByte = reader.read()) != -1){
            if (singleByte == 10 || singleByte == 32){
                writer.write((char) singleByte);
            }else{
                writer.write(String.valueOf(singleByte));
            }
        }

        inputBuffer.close();
        writer.flush();
        writer.close();
    }
}
