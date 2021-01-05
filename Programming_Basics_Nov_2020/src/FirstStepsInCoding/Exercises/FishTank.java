package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//         Input data for the fish tank
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percentage = Double.parseDouble(scanner.nextLine());

//        Calculating the volume of the fish tank
        int volume = length * width * height;
        double liters = volume * 0.001;

//        Calculating actual liters required based on percentage filled
        double actualVolume = liters - (liters * percentage/100);

//        Printing liters needed
        System.out.printf("%.2f", actualVolume);
    }
}
