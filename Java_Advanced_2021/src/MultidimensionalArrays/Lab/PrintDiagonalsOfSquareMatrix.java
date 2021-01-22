package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] matrix = buildMatrix(scanner);

        int row = 0, col =0;

        while (row < matrix.length && col < matrix.length){
            System.out.print(matrix[row++][col++] + " ");
        }

        row = matrix.length - 1;
        col = 0;

        System.out.println();

        while (row >= 0 && col < matrix[0].length){
            System.out.print(matrix[row--][col++] + " ");
        }
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
