package Workshop_2;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numberArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int key = Integer.parseInt(scanner.nextLine());

        int index = getIndex(numberArray, key);

        System.out.println(index);
    }

    private static int getIndex(int[] numberArray, int key) {
        int start = 0;
        int end = numberArray.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (key < numberArray[mid]){
                end = mid - 1;
            }else if (key > numberArray[mid]){
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
