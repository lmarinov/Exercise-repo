package StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class SerializeCustomObject {
    private static final String PATH = "src/StreamsFilesAndDirectories/Exercise/course.ser";

    public static void main(String[] args) {
        Course course = new Course("Java Advanced", 200);

        try (FileOutputStream fos = new FileOutputStream(PATH)){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(course);

        }catch (IOException e){
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(PATH)){
            ObjectInputStream oos = new ObjectInputStream(fis);
            Course deserializedCourse = (Course) oos.readObject();
            System.out.println(deserializedCourse);

        }catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    private static class Course implements Serializable{
        private String name;
        private int studentsCount;

        public Course(String name, int studentsCount) {
            this.name = name;
            this.studentsCount = studentsCount;
        }

        public String getName() {
            return name;
        }

        public int getStudentsCount() {
            return studentsCount;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setStudentsCount(int studentsCount) {
            this.studentsCount = studentsCount;
        }

        @Override
        public String toString() {
            return String.format("%s -> %d", this.getName(), this.getStudentsCount());
        }
    }
}
