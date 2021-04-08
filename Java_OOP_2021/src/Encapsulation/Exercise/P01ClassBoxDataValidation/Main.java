package Encapsulation.Exercise.P01ClassBoxDataValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box myBox;
        try {
            double length = Double.parseDouble(scanner.nextLine());
            double width = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());
            myBox = new Box(length, width, height);

            System.out.printf("Surface Area - %.2f%n", myBox.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", myBox.calculateLateralSurfaceArea());
            System.out.printf(("Volume - %.2f"), myBox.calculateVolume());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
