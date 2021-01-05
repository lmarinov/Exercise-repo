package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class InchesToCentimeters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Read input in inches
        double inches = Double.parseDouble(scanner.nextLine());

//        Calculate centimeters
        double centimeters = inches * 2.54;

//        Print output
        System.out.print(centimeters);
    }
}
