package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = buildMatrix(scanner);
        int rightDiagonalSum = findRightDiagonalSum(matrix);
        int leftDiagonalSum = findLeftDiagonalSum(matrix);

        printDifference(rightDiagonalSum, leftDiagonalSum);
    }

    private static void printDifference(int rightDiagonalSum, int leftDiagonalSum) {
        System.out.println(Math.abs(rightDiagonalSum - leftDiagonalSum));
    }

    private static int findLeftDiagonalSum(int[][] matrix) {
        int row = 0;
        int col = 0;
        int sum = 0;
        while (row < matrix.length && col < matrix[0].length){
            sum += matrix[row][col];
            row++;
            col++;
        }
        return sum;
    }

    private static int findRightDiagonalSum(int[][] matrix) {
        int row = 0;
        int col = matrix[0].length - 1;
        int sum = 0;
        while (row < matrix.length && col >= 0){
            sum += matrix[row][col];
            row++;
            col--;
        }
        return sum;
    }

    private static int[][] buildMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readIntArray(scanner);
        }
        return matrix;
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
