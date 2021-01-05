package NestedLoops.Exercises;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int secondCounter = 1;
        int current = 1;
//        boolean isDone = false;

//        for (int rows = 1; rows <= n; rows++){
//            for (int cols = 1; cols <=rows; cols++){
//                if (current > n){
//                    isDone = true;
//                    break;
//                }
//                System.out.print(current + " ");
//                current++;
//            }
//            if (isDone) break;
//
//            System.out.println();
//        }

        // This is a solution creating too many variables:
        while (current <= n){
            int dif = secondCounter - current;

            for (int i = current; i <= secondCounter; i++){
                if (current > n){
                    break;
                }
                System.out.print(i + " ");
                current++;
            }
            System.out.println();

            secondCounter = 0;
            secondCounter += current + dif + 1;
        }
    }
}
