package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .toArray(String[]::new);
        String last = "";

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].matches("\\+|\\-|\\*|\\/|\\(")) {
                String current = tokens[i];
                last = stack.peek();
                if (!stack.isEmpty() && !last.equals("(") && queue.size() > 1) {

                    if ((current.matches("[\\*|\\/]")
                            && last.matches("[\\*|\\/]"))
                            || current.matches("[\\+|\\-]")) {
                        queue.offer(stack.pop());
                    }
                }
                stack.push(tokens[i]);
            } else if (tokens[i].matches("[0-9|a-zA-Z]+")) {
                queue.offer(tokens[i]);
            } else if (tokens[i].matches("\\)")) {
                while (!stack.peek().equals("(")) {
                    queue.offer(stack.pop());
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) stack.forEach(e -> queue.offer(stack.pop()));
        queue.forEach(e -> System.out.print(e + " "));

    }
}
