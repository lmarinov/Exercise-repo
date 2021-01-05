package ConditionalStatements.Lab;

import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String figure = sc.nextLine();

        switch (figure) {
            case "square": {

                double a = Double.parseDouble(sc.nextLine());
                double result = a * a;

                System.out.printf("%.3f", result);
                break;
            }
            case "triangle": {
                double a = Double.parseDouble(sc.nextLine());
                double h = Double.parseDouble(sc.nextLine());
                double result = (a * h)/2;

                System.out.printf("%.3f", result);
                break;
            }
            case "rectangle": {
                double a = Double.parseDouble(sc.nextLine());
                double b = Double.parseDouble(sc.nextLine());
                double result = a * b;

                System.out.printf("%.3f", result);
                break;
            }
            case "circle": {
                double r = Double.parseDouble(sc.nextLine());
                double result = Math.PI * Math.pow(r, 2);

                System.out.printf("%.3f", result);
                break;
            }
        }

    }
}
