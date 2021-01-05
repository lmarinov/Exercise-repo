package ForLoop.Lab;

import java.util.Scanner;

public class EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int power = scan.nextInt();

        for (int i = 0; i <= power; i++){
            int result = (int) Math.pow(2, i);
            if (i % 2 == 0) System.out.println(result);
        }
    }
}
