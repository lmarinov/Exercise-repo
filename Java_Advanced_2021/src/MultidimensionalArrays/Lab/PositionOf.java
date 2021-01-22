package MultidimensionalArrays.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = buildMatrix(scanner);
        int searchedNumber = Integer.parseInt(scanner.nextLine());

        printMatchingPositions(matrix, searchedNumber);
    }

    private static void printMatchingPositions(int[][] matrix, int searchedNumber) {
        int rows = matrix.length;
        ArrayDeque<String> positions = new ArrayDeque<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(searchedNumber == matrix[row][col]){
                    positions.offer(String.format("%d %d", row, col));
                }
            }
        }

        if (!positions.isEmpty()) positions.forEach(System.out::println);
        else System.out.println("not found");
    }

    private static int[][] buildMatrix(Scanner scanner) {
        int[] tokens = getIntArray(scanner);
        int row = tokens[0];
        int col = tokens[1];

        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = getIntArray(scanner);
        }
        return matrix;
    }

    private static int[] getIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
