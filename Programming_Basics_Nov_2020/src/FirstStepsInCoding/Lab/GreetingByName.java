package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class GreetingByName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Read name of person from the console
        String name = scanner.nextLine();

//        Print greeting
        System.out.printf("Hello, %s!", name);
    }
}
