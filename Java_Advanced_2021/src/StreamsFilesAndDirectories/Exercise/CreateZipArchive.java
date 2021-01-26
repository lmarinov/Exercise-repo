package StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {

    private static final String FIRST_FILE_PATH = "src/StreamsFilesAndDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
    private static final String SECOND_FILE_PATH = "src/StreamsFilesAndDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/inputOne.txt";
    private static final String THIRD_FILE_PATH = "src/StreamsFilesAndDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/inputTwo.txt";
    private static final String ZIP_FILE_PATH = "src\\StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip";

    public static void main(String[] args) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(ZIP_FILE_PATH))) {
            addToZipFile(FIRST_FILE_PATH, zos);
            addToZipFile(SECOND_FILE_PATH, zos);
            addToZipFile(THIRD_FILE_PATH, zos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addToZipFile(String path,ZipOutputStream zos) throws IOException {
        File file = new File(path);
        FileInputStream fileInput = new FileInputStream(file);

        String[] tokens = path.split("/");
        String fileName = tokens[tokens.length - 1];

        ZipEntry zipEntry = new ZipEntry(fileName);
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;

        while ((length = fileInput.read(bytes)) > -1){
            zos.write(bytes, 0, length);
        }

        zos.closeEntry();
        fileInput.close();
    }
}
