package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command;
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();
        ArrayDeque<String> currentURLs = new ArrayDeque<>();

        while (!"Home".equals(command = scan.nextLine())) {

            switch (command) {
                case "back":
                    if (currentURLs.size() < 2) browserHistory.offer("no previous URLs");
                    else {
                        forwardPages.push(currentURLs.pop());
                        browserHistory.offer(currentURLs.peek());
                    }
                    continue;
                case "forward":
                    if (!forwardPages.isEmpty()) {
                        currentURLs.push(forwardPages.peek());
                        browserHistory.offer(forwardPages.pop());
                    } else browserHistory.offer("no next URLs");
                    continue;
            }

            if (!command.equals("")) {
                currentURLs.push(command);
                forwardPages.clear();
                browserHistory.offer(currentURLs.peek());
            }
        }

        browserHistory.forEach(System.out::println);
    }
}
