package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class USDtoBGN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Reading of input
        double usd = Double.parseDouble(scanner.nextLine());

//        Currency conversion from dollars to leva.
        double bgn = usd * 1.79549;

//        Printing of result
        System.out.println(bgn);
    }
}
