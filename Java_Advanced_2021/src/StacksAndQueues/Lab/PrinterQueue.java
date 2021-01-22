package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command;
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!"print". equals(command = scanner.next())){

            if(command.equals("cancel")){
                //logic when action is cancelled
                if (!queue.isEmpty()) System.out.println("Canceled " + queue.poll());
                else System.out.println("Printer is on standby");
            }else{
                //logic when a document is put for printing
                queue.offer(command);
            }
        }

        queue.forEach(System.out::println);

    }
}
