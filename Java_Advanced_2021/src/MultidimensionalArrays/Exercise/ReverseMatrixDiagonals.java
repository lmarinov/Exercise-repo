package MultidimensionalArrays.Exercise;

import java.util.*;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = buildMatrix(rows, cols, scanner);

        int[][] reversedDiagonalsMatrix = reverseDiagonalsOfMatrix(matrix, rows, cols);
        printMatrix(reversedDiagonalsMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach(e -> System.out.println( String.join(" ", Arrays.toString(e).replaceAll("([\\[\\],])", ""))));
    }

    private static boolean isValid(int row, int col, int[][] chamber) {
        return row >= 0 && col >= 0 && row < chamber.length && col < chamber[row].length;
    }

    private static int[][] reverseDiagonalsOfMatrix(int[][] matrix, int rows, int cols){
        ArrayDeque<Integer> integers = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            int count = 0;
            while (isValid(row - count, count, matrix)){
                int tempRow = row - count;
                integers.offer(matrix[tempRow][count]);
                count++;
            }
        }

        for (int col = 1; col < cols; col++) {
            int r = matrix.length - 1;
            int count = 0;
            while (isValid(r - count, col + count, matrix)){
                int tempCol = col + count;
                int tempRow = r - count;
                integers.offer(matrix[tempRow][tempCol]);
                count++;
            }
        }

        int[][] newMatrix = new int[cols + rows - 1][];
        int count = 1;
        int rowsPassed = 1;

        for (int row = cols + rows - 2; row >= 0; row--) {
            int rotationTarget = Math.min(matrix[0].length, matrix.length);

            int[] arr = new int[count];
            for (int i = 0; i < count; i++) {
                arr[i] = integers.poll();
            }

            newMatrix[row] = arr;

            if (rowsPassed < rotationTarget){
                count++;
            }else if (row < rotationTarget){
                count--;
            }

            rowsPassed++;
        }

        return newMatrix;

    }

    private static int[][] buildMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }
}
