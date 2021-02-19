package JavaAdvancedRetakeExam19August2020.P01FlowerWreaths;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class FlowerWreaths {
    private static Deque<Integer> roses = new ArrayDeque<>();
    private static Deque<Integer> lilies = new ArrayDeque<>();
    private static int wreathCount = 0;
    private static int storedFlowerCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(roses::offer);

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(lilies::push);

        while (!roses.isEmpty() && !lilies.isEmpty()){
            int currentSum = roses.peek() + lilies.peek();

            createWreath(currentSum);
        }

        wreathCount += storedFlowerCount / 15;

        if (wreathCount >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreathCount);
        }else{
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreathCount);
        }
    }

    private static void createWreath(int currentSum) {
        if (currentSum < 15){
            storedFlowerCount += currentSum;
            removeFlowers();
        }else if(currentSum == 15){
            wreathCount++;
            removeFlowers();
        }else{
            lilies.push(lilies.pop() - 2);
        }
    }

    private static void removeFlowers() {
        roses.poll();
        lilies.pop();
    }
}
