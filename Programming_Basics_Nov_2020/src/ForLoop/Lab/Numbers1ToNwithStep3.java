package ForLoop.Lab;

import java.util.Scanner;

public class Numbers1ToNwithStep3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        for (int i = 1; i <= number; i += 3){
            System.out.println(i);
        }
    }
}
