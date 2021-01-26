package StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class CopyAPicture {

    private static final String PICTURE_PATH = "src/StreamsFilesAndDirectories/Exercise/firylion.jpg";
    private static final String PICTURE_COPY_PATH = "src/StreamsFilesAndDirectories/Exercise/firylion_copy.jpg";

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(PICTURE_PATH)) {

           FileOutputStream writer = new FileOutputStream(PICTURE_COPY_PATH);
           int oneByte = fis.read();

           while (oneByte != -1){
               writer.write(oneByte);
               oneByte = fis.read();
           }

           writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
