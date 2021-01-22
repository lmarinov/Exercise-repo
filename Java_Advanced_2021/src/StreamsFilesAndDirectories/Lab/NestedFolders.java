package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
//    public static int foldersCount = 0;

    public static void main(String[] args) {

        String fileName = "E:\\Programming\\Exercise-repo\\Java_study_materials\\Java_Advanced_2021\\4 - StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(fileName);

//        dfs(file);

        ArrayDeque<File> files = new ArrayDeque<>();
        files.offer(file);
        int count = 0;
        while (!files.isEmpty()) {
            File currentDir = files.poll();
            File[] nestedFiles = currentDir.listFiles();

            for (File nestedFile : nestedFiles)
                if (nestedFile.isDirectory())
                    files.offer(nestedFile);
            count++;
            System.out.println(currentDir.getName());


        }

        System.out.println(count + " folders");
    }

//    public static void dfs(File file){
//        // Bottom-case
//        // Step
//        foldersCount++;
//        System.out.println(file.getName());
//        for (File f : file.listFiles()) {
//            if (f.isDirectory()){
//                dfs(f);
//            }
//        }
//    }
}
