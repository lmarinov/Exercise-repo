package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class ConcatenateData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        Read name, family name, age and city from the console
        String name = scan.nextLine();
        String familyName = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String city = scan.nextLine();

//        Print message
        System.out.printf("You are %s %s, a %d-years old person from %s.", name, familyName, age, city);
    }
}
