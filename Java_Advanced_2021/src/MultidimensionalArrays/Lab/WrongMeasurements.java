package MultidimensionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] matrix = buildMatrix(scanner);

        int[] indexes = getIntArray(scanner);

        int wrongValue = matrix[indexes[0]][indexes[1]];

        fixWrongValues(matrix, wrongValue);


    }
    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fixWrongValues(int[][] matrix, int wrongValue) {

        ArrayList<int[]> fixInfo = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == wrongValue){
                    int rightValue = calculateRightValue(matrix, wrongValue, row, col);
                    fixInfo.add(new int[]{row, col, rightValue});
                }
            }
        }

        for (int[] info : fixInfo) {
            matrix[info[0]][info[1]] = info[2];
        }

        printMatrix(matrix);
    }

    private static int calculateRightValue(int[][] matrix, int wrongValue, int row, int col) {
        int rightValue = 0;
        // up + down + right + left

        if(isInBounds(matrix, row - 1, col)
                && matrix[row - 1][col] != wrongValue){
            rightValue += matrix[row - 1][col];
        }
        if(isInBounds(matrix, row + 1, col)
                && matrix[row + 1][col] != wrongValue){
            rightValue += matrix[row + 1][col];
        }
        if(isInBounds(matrix, row, col + 1)
                && matrix[row][col + 1] != wrongValue){
            rightValue += matrix[row][col + 1];
        }
        if(isInBounds(matrix, row, col - 1)
                && matrix[row][col - 1] != wrongValue){
            rightValue += matrix[row][col - 1];
        }

        return rightValue;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row < matrix.length && row >= 0 && col <  matrix[row].length && col >=0;
    }

    private static boolean isOutOfBounds(int[][] matrix, int row, int col){
        return !isInBounds(matrix, row, col);
    }

    private static int[][] buildMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
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
