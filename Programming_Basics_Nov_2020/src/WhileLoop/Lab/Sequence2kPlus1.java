package WhileLoop.Lab;

import java.util.Scanner;

public class Sequence2kPlus1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int printedNumber = 1;

        while (n >= printedNumber){
            System.out.println(printedNumber);

            printedNumber = printedNumber * 2 + 1;
        }
    }
}
