package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MathPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> participants = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

//        ArrayDeque<String> participants = new ArrayDeque<>();
//        Arrays.stream(scanner.nextLine()
//                .split("\\s+"))
//                .forEach(s -> participants.offer(s));

        int n = Integer.parseInt(scanner.nextLine());
        int count = 1;

        while (participants.size() > 1){
            for (int i = 0; i < n - 1; i++) {
                participants.offer(participants.poll());
            }
            if (isPrime(count)) {
                System.out.println("Prime " + participants.peek());
            }else {
                System.out.println("Removed " + participants.poll());
            }
            count++;
        }

        System.out.println("Last is " + participants.poll());
    }

    public static boolean isPrime(int num){
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        if (num == 1) flag = true;

        return !flag;
    }
}
