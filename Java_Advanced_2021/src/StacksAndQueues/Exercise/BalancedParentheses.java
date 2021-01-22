package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] input = Arrays.stream(scanner.nextLine().split("")).toArray(String[]::new);
        boolean isBalanced = true;

        if (input.length % 2 == 0 && input[0].matches("\\(|\\{|\\[")) {
            for (String el : input) {
                if (el.matches("\\(|\\{|\\[")) {
                    stack.push(el);
                } else {
                    switch (el) {
                        case ")":
                            if (!stack.pop().equals("(")) {
                                isBalanced = false;
                            }
                            break;
                        case "]":
                            if (!stack.pop().equals("[")) {
                                isBalanced = false;
                            }
                            break;
                        case "}":
                            if (!stack.pop().equals("{")) {
                                isBalanced = false;
                            }
                            break;
                    }
                }
            }

        } else {
            isBalanced = false;
        }

        if (isBalanced) System.out.println("YES");
        else System.out.println("NO");

    }
}
