package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command;
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> currentURLs = new ArrayDeque<>();

        while (!"Home".equals(command = scan.nextLine())) {

            if ("back".equals(command)) {
                if (currentURLs.size() < 2) browserHistory.offer("no previous URLs");
                else {
                    currentURLs.pop();
                    browserHistory.offer(currentURLs.peek());
                }
            } else {
                if (!command.equals("")) {
                    currentURLs.push(command);
                    browserHistory.offer(currentURLs.peek());
                }
            }
        }

        browserHistory.forEach(System.out::println);
    }
}
