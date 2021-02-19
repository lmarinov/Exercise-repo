package SetsAndMaps.Lab;

import java.util.*;

import static java.lang.String.format;

public class AverageStudentsGrades {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentRecord = new TreeMap<>();
        while (numberOfStudents-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            Double grade = Double.parseDouble(input[1]);
            studentRecord.putIfAbsent(name, new ArrayList<Double>());
            studentRecord.get(name).add(grade);
        }

        Deque<Double> averages = new ArrayDeque<>();

        for (Map.Entry<String, List<Double>> s : studentRecord.entrySet()) {
            double sum = 0.0;
            int size = s.getValue().size();
            for (int i = 0; i < size; i++) {
                sum += s.getValue().get(i);
            }
            averages.offer(sum / size);
        }

        studentRecord
                .forEach((k, v) -> System.out.printf("%s -> %s(avg: %.2f)%n", k,
                        myFormat(v), averages.poll()));

        //DO NOT USE .sum() and .average() for double or float variables!!!!

//        studentRecord.forEach((key, value) -> {
//
//            double sum = 0;
//            for (int i = 0; i < value.size(); i++) {
//                sum += value.get(i);
//            }
//            double avgSum = sum / value.size();
//
//            System.out.print(key + " -> ");
//            value.forEach(e -> System.out.printf("%.2f ", e));
//            System.out.printf("(avg: %.2f)%n", avgSum);
//
//        });
    }

    public static String myFormat(List<Double> values) {
        StringBuilder sb = new StringBuilder();
        values.forEach(e -> sb.append(format("%.2f ", e)));
        return sb.toString();
    }
}
