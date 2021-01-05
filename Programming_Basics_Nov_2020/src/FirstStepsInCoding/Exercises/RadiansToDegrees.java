package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class RadiansToDegrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//      Read input in radians.
        double radians = Double.parseDouble(scanner.nextLine());

//      Calculate output in degrees.
        double degrees = radians * 180 / Math.PI;

//      Print output
        System.out.printf("%.0f", degrees);
    }
}
