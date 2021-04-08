package Workshop_2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergeSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        String output = Arrays.stream(mergeSort(inputNumbers)).boxed().map(String::valueOf).collect(Collectors.joining(" "));

        System.out.println(output);
    }

    private static int[] mergeSort(int[] inputNumbers) {

        if (inputNumbers.length == 1){
            return inputNumbers;
        }

        int halfIndex = inputNumbers.length / 2;
        int firstArrayLength = halfIndex;
        int secondArrayLength = inputNumbers.length - halfIndex;

        int[] firstPartition = new int[firstArrayLength];
        int[] secondPartition = new int[secondArrayLength];

        System.arraycopy(inputNumbers, 0, firstPartition, 0, firstArrayLength);

        if (firstArrayLength + secondArrayLength - firstArrayLength >= 0)
            System.arraycopy(inputNumbers, firstArrayLength, secondPartition, firstArrayLength - firstArrayLength, firstArrayLength + secondArrayLength - firstArrayLength);

        firstPartition = mergeSort(firstPartition);
        secondPartition = mergeSort(secondPartition);

        int mainindex = 0;
        int firstPartitionIndex = 0;
        int secondPartitionIndex = 0;

        while (firstPartitionIndex < firstArrayLength && secondPartitionIndex < secondArrayLength){
            if (firstPartition[firstPartitionIndex] < secondPartition[secondPartitionIndex]){
                inputNumbers[mainindex] = firstPartition[firstPartitionIndex];

                mainindex++;
                firstPartitionIndex++;
            }else{
                inputNumbers[mainindex] = secondPartition[secondPartitionIndex];

                mainindex++;
                secondPartitionIndex++;
            }
        }

        while (firstPartitionIndex < firstArrayLength){
            inputNumbers[mainindex] = firstPartition[firstPartitionIndex];

            mainindex++;
            firstPartitionIndex++;
        }

        while (secondPartitionIndex < secondArrayLength){
            inputNumbers[mainindex] = secondPartition[secondPartitionIndex];

            mainindex++;
            secondPartitionIndex++;
        }
        return inputNumbers;
    }
}
