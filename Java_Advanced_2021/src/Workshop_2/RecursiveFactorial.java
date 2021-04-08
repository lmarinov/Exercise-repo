package Workshop_2;

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(calculateFactorial(number));
    }

    private static long calculateFactorial(int number) {
        if (number == 1){
            return 1;
        }
        return number * calculateFactorial(number - 1);
    }
}
