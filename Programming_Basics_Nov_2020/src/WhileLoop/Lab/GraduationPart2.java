package WhileLoop.Lab;

import java.util.Scanner;

public class GraduationPart2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String studentName = scan.nextLine();
        int failCount = 0;
        int gradeCount = 1;
        double averageGrade = 0.0;

        while (gradeCount <= 12){
            if (failCount == 2) { System.out.printf("%s has been excluded at %d grade", studentName, gradeCount); break;}

            double grade = Double.parseDouble(scan.nextLine());

            if (grade < 4.00) {
                failCount++;
                continue ;
            }else {
                averageGrade += grade;
            }

            if (gradeCount == 12) { averageGrade = averageGrade / 12; System.out.printf("%s graduated. Average grade: %.2f", studentName, averageGrade); break;}

            gradeCount++;
        }
    }
}
