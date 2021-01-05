package ConditionalStatements.Exercises;

import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int initialScore = Integer.parseInt(sc.nextLine());
        double bonus = 0;

        if (initialScore <= 100){
            bonus = 5;
        }else if (initialScore <= 1000) {
            bonus = initialScore * 0.2;
        }else {
            bonus = initialScore * 0.1;
        }

        if (initialScore % 2 == 0){
            bonus += 1;
        }

        if (initialScore % 5 == 0 && initialScore % 2 != 0){
            bonus += 2;
        }

        double result = bonus + initialScore;
        System.out.printf("%.1f%n%.1f",bonus, result);
    }
}
