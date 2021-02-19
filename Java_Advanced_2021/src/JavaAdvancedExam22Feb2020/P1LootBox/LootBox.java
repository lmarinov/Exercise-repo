package JavaAdvancedExam22Feb2020.P1LootBox;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class LootBox {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Deque<Integer> lootQueue = new ArrayDeque<>();
        Deque<Integer> lootStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(lootQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(lootStack::push);

        int totalSum = 0;

        while (!lootQueue.isEmpty() && !lootStack.isEmpty()){
            int currentSum = lootQueue.peek() + lootStack.peek();

            if (currentSum % 2 == 0){
                totalSum += currentSum;
                lootQueue.poll();
                lootStack.pop();
            }else{
                lootQueue.offer(lootStack.pop());
            }
        }

        if (lootQueue.isEmpty()){
            System.out.println("First lootbox is empty");
        }else{
            System.out.println("Second lootbox is empty");
        }

        if (totalSum >= 100){
            System.out.println("Your loot was epic! Value: " + totalSum);
        }else{
            System.out.println("Your loot was poor... Value: " + totalSum);
        }
    }
}
