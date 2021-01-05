package ForLoop.Exercises;

import java.util.Scanner;

public class DivideWithoutRemaineder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        double p1 = 0.0;
        double p2 = 0.0;
        double p3 = 0.0;

        for (int i = 0; i < n; i++){
            double number = scan.nextDouble();

            if (number % 2 == 0) p1++;
            if (number % 3 == 0) p2++;
            if (number % 4 == 0) p3++;
        }

        p1 = p1 / n * 100;
        p2 = p2 / n * 100;
        p3 = p3 / n * 100;

        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%", p1, p2, p3);
    }
}
