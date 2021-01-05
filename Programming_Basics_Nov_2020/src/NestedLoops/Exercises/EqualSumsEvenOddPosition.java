package NestedLoops.Exercises;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());

        for (int i = startNum; i <= endNum; i++){
          String currentNum = "" + i;
          int evenSum= 0;
          int oddSum = 0;
          for (int index = 0; index < currentNum.length(); index++){
              if(index % 2 == 0){
                  evenSum += currentNum.charAt(index);
              }else {
                  oddSum += currentNum.charAt(index);
              }
          }

            if (evenSum == oddSum){
                System.out.print(i + " ");
            }
        }
    }
}
