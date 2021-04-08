package Workshop_2;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(sum(numbers, numbers.length - 1));

    }

    private static int sum(int[] nums, int index){
        if (index == 0){
            return nums[index];
        }
        return nums[index] + sum(nums, index - 1);
    }
}
