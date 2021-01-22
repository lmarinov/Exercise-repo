package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstLineInput = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = firstLineInput[0]; // numbers count we have to add in stack
        int s = firstLineInput[1]; // numbers count we have to pop
        int x = firstLineInput[2]; // check whether x is contained in the stack

        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();

//        Arrays.stream(scanner.nextLine()
//                .split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .forEach(numbersQueue::offer);

        int [] numbersToAdd = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < n; i++) {
            int number = numbersToAdd[i];
            numbersQueue.offer(number);
        }

        while (s > 0 && !numbersQueue.isEmpty()){
            numbersQueue.poll();
            s--;
        }

        if (numbersQueue.isEmpty()){
            System.out.println(0);
        }
        else if (numbersQueue.contains(x)){
            System.out.println("true");
        }else {
            int minElement = Collections.min(numbersQueue);
            System.out.println(minElement);
        }
    }
}
