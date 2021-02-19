package SetsAndMaps.Lab;

import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> studentWithGrades = new TreeMap<>();

        while (n-- > 0){
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            double averageGrade;
            double sum = 0.0;

            for (double grade : grades) {
                sum += grade;
            }

            averageGrade = sum / grades.length;

            studentWithGrades.put(name, averageGrade);
        }

        studentWithGrades.forEach((k,v) -> {
            System.out.printf("%s is graduated with %s%n", k, v);
        });
    }
}
