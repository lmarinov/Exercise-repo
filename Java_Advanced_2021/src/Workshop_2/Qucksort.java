package Workshop_2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Qucksort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] unsortedNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(unsortedNumbers);
        String output = Arrays.stream(unsortedNumbers).boxed().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(output);
    }

    private static void sort(int[] unsortedNumbers) {
        sort(unsortedNumbers, 0, unsortedNumbers.length - 1);
    }

    private static void sort(int[] unsortedNumbers, int low, int high) {
            if (low < high){
                int pi = partition(unsortedNumbers, low, high);

                sort(unsortedNumbers, low, pi - 1);
                sort(unsortedNumbers, pi + 1, high);
            }
    }

    private static int partition(int[] unsortedNumbers, int low, int high) {
        int pivot = unsortedNumbers[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (unsortedNumbers[j] <= pivot){
                i++;

                int temp = unsortedNumbers[i];
                unsortedNumbers[i] = unsortedNumbers[j];
                unsortedNumbers[j] = temp;
            }
        }

        int temp = unsortedNumbers[i + 1];
        unsortedNumbers[i + 1] = unsortedNumbers[high];
        unsortedNumbers[high] = temp ;

        return i + 1;
    }
}
