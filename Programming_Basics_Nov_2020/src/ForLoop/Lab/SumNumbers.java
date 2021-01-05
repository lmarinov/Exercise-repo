package ForLoop.Lab;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = scan.nextInt();
        int sum = 0;

        for (int i = 0; i < count; i++){
            int number = scan.nextInt();
            sum += number;
        }

        System.out.println(sum);
    }
}
