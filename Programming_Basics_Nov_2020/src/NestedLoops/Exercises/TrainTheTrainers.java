package NestedLoops.Exercises;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juryMembers = Integer.parseInt(scanner.nextLine());
        String  presentationTitle = scanner.nextLine();
        int assessmentCount = 0;
        double finalAverageSum = 0.0;

        while (!presentationTitle.equals("Finish")){
            double marksTotal = 0.0;

            for (int i = 0; i < juryMembers; i++){
                double mark = Double.parseDouble(scanner.nextLine());
                marksTotal += mark;
            }

            double averageMark = marksTotal / juryMembers;
            finalAverageSum += averageMark;
            assessmentCount++;
            System.out.printf("%s - %.2f.%n", presentationTitle, averageMark);

            presentationTitle = scanner.nextLine();
        }

        double finalMark = finalAverageSum / assessmentCount;
        System.out.printf("Student's final assessment is %.2f.", finalMark);
    }
}