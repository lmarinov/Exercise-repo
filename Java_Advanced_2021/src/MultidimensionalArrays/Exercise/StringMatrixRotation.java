package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        char[][] matrix = buildMatrix(scanner);
//        rotateMatrix(command, matrix);
        printMatrix(matrix);
    }

    private static void rotateMatrix(String command, char[][] matrix) {

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%s ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static char[][] buildMatrix(Scanner scanner) {
        String[] tokens = scanner.nextLine().split("\n");
        char[][] matrix = new char[tokens.length][];

        for (int token = 0; token < tokens.length; token++) {
            matrix[token] = Arrays.toString(tokens[token].split("\\s+")).toCharArray();
        }

        return matrix;
    }
}
