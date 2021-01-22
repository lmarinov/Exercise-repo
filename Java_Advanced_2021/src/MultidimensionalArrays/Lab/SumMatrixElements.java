package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = buildMatrix(scanner, ", ");

        int sum = matrixElementsSum(matrix);

        System.out.printf("%d%n%d%n%d%n", matrix.length, matrix[0].length, sum);
    }

    private static int matrixElementsSum(int[][] matrix) {
//   iterates through the matrix and adds all the values together.
        return Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .sum();
    }

    private static int[][] buildMatrix(Scanner scanner, String pattern) {
        int[] tokens = getIntArray(scanner, pattern);
        int row = tokens[0];
        int col = tokens[1];

        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = getIntArray(scanner, pattern);
        }
        return matrix;
    }

    private static int[] getIntArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
