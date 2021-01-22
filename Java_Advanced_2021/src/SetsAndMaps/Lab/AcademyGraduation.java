package SetsAndMaps.Lab;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> studentWithGrades = new TreeMap<>();

        while (n-- > 0){
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            studentWithGrades.put(name, grades);
        }

        DecimalFormat df = new DecimalFormat("###.####");

        studentWithGrades.forEach((k,v) -> {
            System.out.printf("%s is graduated with %s%n", k, fmt(Arrays.stream(v).average().orElse(0)));
        });
    }

    public static String fmt(double d)

    {

        if(d == (long) d)

            return String.format("%d",(long)d);

        else

            return String.format("%s",d);

    }
}
