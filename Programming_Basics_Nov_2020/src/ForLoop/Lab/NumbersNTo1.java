package ForLoop.Lab;

import java.util.Scanner;

public class NumbersNTo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();

        for (int i = number; i >= 1; i--){
            System.out.println(i);
        }
    }
}
