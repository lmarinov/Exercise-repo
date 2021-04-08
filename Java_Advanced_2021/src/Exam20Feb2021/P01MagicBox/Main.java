package Exam20Feb2021.P01MagicBox;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Deque<Integer> firstBox = new ArrayDeque<>();
        Deque<Integer> secondBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstBox::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBox::push);

        int totalSum = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()){
            int currentSum = firstBox.peek() + secondBox.peek();

            if (currentSum % 2 == 0){
                totalSum += currentSum;
                firstBox.poll();
                secondBox.pop();
            }else{
                firstBox.offer(secondBox.pop());
            }
        }

        if (firstBox.isEmpty()){
            System.out.println("First magic box is empty.");
        }else{
            System.out.println("Second magic box is empty.");
        }

        if (totalSum >= 100){
            System.out.println("Wow, your prey was epic! Value: " + totalSum);
        }else{
            System.out.println("Poor prey... Value: " + totalSum);
        }
    }
}
