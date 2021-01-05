package WhileLoop.Exercises;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int badCounter = 0;
        double averageGrade = 0.0;
        int badGradesThreshold = Integer.parseInt(scan.nextLine());
        int problemsCount = 0;
        String problemName = scan.nextLine();
        String lastProblem = "";

        while (!problemName.equals("Enough")){
            lastProblem = problemName;
            int currentGrade = Integer.parseInt(scan.nextLine());

            if (currentGrade <= 4.00) badCounter++;

            if (badCounter == badGradesThreshold) break;

            averageGrade += currentGrade;
            problemsCount++;
            problemName = scan.nextLine();
        }

        if (badCounter == badGradesThreshold){
            System.out.printf("You need a break, %d poor grades.", badCounter);
        }else {
            System.out.printf("Average score: %.2f%nNumber of problems: %d%nLast problem: %s", averageGrade/problemsCount, problemsCount, lastProblem);
        }
    }
}
