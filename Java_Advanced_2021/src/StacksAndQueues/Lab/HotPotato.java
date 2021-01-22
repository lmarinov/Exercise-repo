package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> participants = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));
        int n = Integer.parseInt(scanner.nextLine());


        while (participants.size() > 1){
            for (int i = 0; i < n - 1; i++) {
                participants.offer(participants.poll());
            }
            System.out.println("Removed " + participants.poll());
        }

        System.out.println("Last is " + participants.poll());
    }

}
