package MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rotationDegrees = Integer.parseInt(scanner.nextLine().split("\\(")[1].replace(")", ""));
        char[][] matrix = buildMatrix(scanner);
        char[][] rotatedMatrix = rotateMatrix(rotationDegrees, matrix);
        printMatrix(rotatedMatrix);


    }

    private static char[][] rotateMatrix(int rotationDegrees, char[][] matrix) {
        char[][] rotatedMatrix = new char[matrix.length][matrix[0].length];
        int rotation = rotationDegrees / 90;

        while (rotation > 3) {
            rotation = rotation % 4;
        }

        int rows;
        int cols;

        switch (rotation) {
            case 0:
                rotatedMatrix = matrix;
                break;
            case 1:
                rows = matrix[0].length;
                cols = matrix.length;

                rotatedMatrix = new char[rows][cols];

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        rotatedMatrix[row][col] = matrix[cols - 1 - col][row];
                    }
                }
                break;
            case 2:
                rows = matrix.length;
                cols = matrix[0].length;

                rotatedMatrix = new char[rows][cols];

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        rotatedMatrix[row][col] = matrix[rows - row - 1][cols - col - 1];
                    }
                }
                break;
            case 3:
                rows = matrix[0].length;
                cols = matrix.length;

                rotatedMatrix = new char[rows][cols];

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        rotatedMatrix[row][col] = matrix[col][rows - 1 - row];
                    }
                }
                break;
        }
        return rotatedMatrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%s", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static char[][] buildMatrix(Scanner scanner) {
        String command;
        List<String> lines = new ArrayList<>();
        while (!"END".equals(command = scanner.nextLine())) {
            lines.add(command);
        }
        char[][] matrix = new char[lines.size()][];

        for (int token = 0; token < lines.size(); token++) {
            matrix[token] = lines.get(token).toCharArray();
        }

        int biggestCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            if (biggestCol < matrix[row].length - 1) {
                biggestCol = matrix[row].length - 1;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            int col = matrix[row].length - 1;
            int dif = biggestCol - col;
            if (biggestCol > col) {
                String temp = String.valueOf(matrix[row]);
//                String added = " ".repeat(dif);
                String added = String.join("", Collections.nCopies(dif, " "));
                temp = temp + added;
                matrix[row] = temp.toCharArray();
            }

        }

        return matrix;
    }
}
