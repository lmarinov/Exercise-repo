package MultidimensionalArrays.Exercise;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] matrix = buildMatrix(scanner);
        printMatrix(nukeMatrix(matrix, scanner));


    }

    private static boolean isValid(int row, int col, String[][] chamber) {
        return row >= 0 && col >= 0 && row < chamber.length && col < chamber[row].length;
    }

    private static String[][] nukeMatrix(String[][] matrix, Scanner scanner){
        String command;
        while (!"Nuke it from orbit".equals(command = scanner.nextLine())) {
            int[] tokens = getTokens(command);
            int rowOfImpact = tokens[0];
            int colOfImpact = tokens[1];
            int radius = tokens[2];

            removeElements(matrix, rowOfImpact, colOfImpact, radius);

            matrix = Arrays.stream(matrix).filter(r -> Arrays.stream(r).count() != 0).toArray(String[][]::new);

        }
        return matrix;
    }

    private static void removeElements(String[][] matrix, int rowOfImpact, int colOfImpact, int radius) {

        //delete from bottom

        for (int row = rowOfImpact + radius; row >= rowOfImpact - radius; row--) {
            if (isValid(row, colOfImpact, matrix) && row != rowOfImpact) {
                matrix[row][colOfImpact] = null;
            }
        }

        //delete from right

        for (int col = colOfImpact + radius; col >= colOfImpact - radius; col--) {
            if (isValid(rowOfImpact, col, matrix)) {
                matrix[rowOfImpact][col] = null;
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(matrix[r]).filter(Objects::nonNull).toArray(String[]::new);
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            System.out.println(String.join(" ", row));
        }
    }

    private static String[][] buildMatrix(Scanner scanner) {
        int[] tokens = getTokens(scanner.nextLine());

        int rows = tokens[0];
        int cols = tokens[1];

        String[][] matrix = new String[rows][cols];

        int counter = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = String.format("%d", counter++);
            }
        }

        return matrix;
    }

    private static int[] getTokens(String input) {
        return Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
