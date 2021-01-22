package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSunOf2x2Submatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = buildMatrix(scanner, ", ");
        int[][] biggestSub = findBiggestSubmatrix(matrix);
        printMatrix(biggestSub);
        System.out.println(matrixElementsSum(biggestSub));

    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[][] findBiggestSubmatrix(int[][] matrix) {
        int[][] newMatrix = new int[2][2];
        int sum = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int[][] submatrix = new int[2][2];
                int currentSum = matrixElementsSum(fillMatrix(matrix, submatrix, row, col));

                if(currentSum > sum){
                    newMatrix = submatrix;
                    sum = currentSum;
                }
            }
        }

        return newMatrix;
    }

    private static int[][] fillMatrix(int[][] matrix, int[][] submatrix, int row, int col) {
        int r1 = 0;
        int c1 = 0;

        for (int r = row; r <= row + 1; r++) {
            for (int c = col; c <= col + 1; c++) {
                submatrix[r1][c1] = matrix[r][c];
                c1++;
            }
            r1++;
            c1 = 0;
        }
        return submatrix;
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
