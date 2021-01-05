package Exam;

import java.util.Scanner;

public class Substitute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        int subs = 0;

        if (subs < 6){
            for (int firstFirst = k; firstFirst <= 8; firstFirst++){
                for (int firstSecond = 9; firstSecond >= l; firstSecond--){
                    for (int secondFirst = m; secondFirst <= 8; secondFirst++){
                        for (int secondSecond = 9; secondSecond >= n; secondSecond--){
                            if (subs == 6) break;
                            boolean isValid = firstFirst % 2 == 0 && secondFirst % 2 == 0 && firstSecond % 2 == 1 && secondSecond % 2 == 1;
                            boolean areEqual = firstFirst == secondFirst && firstSecond == secondSecond;
                            if (isValid && areEqual) {
                                System.out.println("Cannot change the same player.");
                            }
                            else if (isValid) {
                                System.out.printf("%d%d - %d%d%n", firstFirst, firstSecond, secondFirst, secondSecond);
                                subs++;
                            }
                        }
                    }
                }
            }
        }
    }
}
