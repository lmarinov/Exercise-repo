package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        String text = scanner.nextLine();
//        System.out.println(text);
        int num1 = Integer.parseInt(scanner.nextLine());
        double num2 = Double.parseDouble(scanner.nextLine());

        System.out.println(num1);
        System.out.println(num2);
    }
}
