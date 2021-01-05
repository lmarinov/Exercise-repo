package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class SquareArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Take input for the side 'a' of the square
        int a = Integer.parseInt(scanner.nextLine());

//        Calculate the area of the square
        int area = a * a;

//        Print area
        System.out.print(area);
    }
}
