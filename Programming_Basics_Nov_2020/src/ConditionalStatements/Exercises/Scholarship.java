package ConditionalStatements.Exercises;

import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double incomeInLeva = Double.parseDouble(sc.nextLine());
        double averageGrade = Double.parseDouble(sc.nextLine());
        double minimumWage = Double.parseDouble(sc.nextLine());

        double socialScholarship = 0;
        double resultsScholarship = 0;

        if (averageGrade >= 5.5){
            resultsScholarship = Math.floor(averageGrade * 25);
        }else if (incomeInLeva < minimumWage && averageGrade > 4.5){
            socialScholarship = Math.floor(minimumWage * 0.35);
        }

        if (incomeInLeva < minimumWage && averageGrade > 4.5 && socialScholarship > resultsScholarship){

            System.out.printf("You get a Social scholarship %.0f BGN%n", Math.floor(socialScholarship));
        }else if (averageGrade >= 5.5 && socialScholarship <= resultsScholarship) {

            System.out.printf("You get a scholarship for excellent results %.0f BGN%n", Math.floor(resultsScholarship));
        }else {
            System.out.println("You cannot get a scholarship!");
        }
    }
}
