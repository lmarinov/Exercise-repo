package StreamsFilesAndDirectories.Lab;

import java.io.File;

public class NestedFolders {
    public static int foldersCount = 1;

    public static void main(String[] args) {

        String fileName = "E:\\Programming\\Exercise-repo\\Java_study_materials\\Java_Advanced_2021\\4 - StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(fileName);

        dfs(file);

        System.out.println(foldersCount + " folders");
    }

    public static void dfs(File file){
        // Bottom-case
        // Step
        foldersCount++;
        for (File f : file.listFiles()) {
            if (f.isDirectory()){
                dfs(f);
            }
        }

        System.out.println(file.getName());
    }
}
