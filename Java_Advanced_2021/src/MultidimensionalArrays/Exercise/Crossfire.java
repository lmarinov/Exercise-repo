package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] matrix = buildMatrix(scanner);
        String[][] nukedMatrix = nukeMatrix(matrix, scanner);
        printMatrix(nukedMatrix);


    }

    private static boolean isValid(int row, int col, String[][] chamber) {
        return row >= 0 && col >= 0 && row < chamber.length && col < chamber[row].length;
    }

    private static String[][] nukeMatrix(String[][] matrix, Scanner scanner) {
        String command;
        while (!"Nuke it from orbit".equals(command = scanner.nextLine())) {
            int[] tokens = getTokens(command);
            int rowOfImpact = tokens[0];
            int colOfImpact = tokens[1];
            int radius = tokens[2];


            //delete top
            if (rowOfImpact != 0) {
                for (int row = rowOfImpact - 1; row >= rowOfImpact - radius; row--) {
                    if (isValid(row, colOfImpact, matrix)) {
                        matrix[row][colOfImpact] = ",";
                        String temp = String.join(" ", matrix[row]).replace(",", "");
                        matrix[row] = temp.split("\\s+");
                    }
                }
            }

            //delete right

                for (int col = colOfImpact + 1; col <= colOfImpact + radius; col++) {
                    if (isValid(rowOfImpact, col, matrix)) {
                        matrix[rowOfImpact][col] = ",";
                        String temp = String.join(" ", matrix[rowOfImpact]).replace(",", "");
                        matrix[rowOfImpact] = temp.split("\\s+");
                    }
                }

            //delete bottom


                for (int row = rowOfImpact + 1; row <= rowOfImpact + radius; row++) {
                    if (isValid(row, colOfImpact, matrix)) {
                        matrix[row][colOfImpact] = ",";
                        String temp = String.join(" ", matrix[row]).replace(",", "");
                        matrix[row] = temp.split("\\s+");
                    }
                }


            //delete left

            if (colOfImpact != 0) {
                for (int col = colOfImpact; col >= colOfImpact - radius; col--) {
                    if (isValid(rowOfImpact, col, matrix)) {
                        matrix[rowOfImpact][col] = ",";
                        String temp = String.join(" ", matrix[rowOfImpact]).replace(",", "");
                        matrix[rowOfImpact] = temp.split("\\s+");
                    }
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%s ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static String[][] buildMatrix(Scanner scanner) {
        int[] tokens = getTokens(scanner.nextLine());

        int rows = tokens[0];
        int cols = tokens[1];

        String[][] matrix = new String[rows][cols];

        int counter = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (counter > 0) {
                    matrix[row][col] = String.format("%d", (counter * cols) + col + 1);
                } else {
                    matrix[row][col] = String.format("%d", col + 1);
                }
            }
            counter++;
        }

        return matrix;
    }

    private static int[] getTokens(String input) {
        return Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
