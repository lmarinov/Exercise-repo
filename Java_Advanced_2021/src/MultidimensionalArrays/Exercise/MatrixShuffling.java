package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] tokens = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = tokens[0];
        int m = tokens[1];

        String[][] matrix = new String[n][m];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        String command;
        while (!"END".equals(command = scanner.nextLine())){
            if(isValid(command)){
                String[] data = command.split("\\s+");

                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);

                swapElements(row1, col1, row2, col2, matrix);
            }else{
                System.out.println("Invalid input!");
            }
        }

    }
    // to sum two numbers without 3rd variable use division and addition

    private static void swapElements(int row1, int col1, int row2, int col2, String[][] matrix) {
        if (isValid(row1, col1, matrix)&& isValid(row2, col2, matrix)){
            String tempElement = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = tempElement;
            printMatrix(matrix);
        }else {
            System.out.println("Invalid input!");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String str : strings) {
                System.out.printf("%s ", str);
            }

            System.out.println();
        }
    }

    private static boolean isValid(int row, int col, String[][] matrix) {
        boolean isRowValid = row >= 0 && row < matrix.length;
        return isRowValid && col >= 0 && col < matrix[row].length;
    }

    private static boolean isValid(String input) {
        String[] data = input.split("\\s+");
        int row1;
        int row2;
        int col1;
        int col2;

        if (data[0].equals("swap") && data.length == 5) {
            try {
                row1 = Integer.parseInt(data[1]);
                row2 = Integer.parseInt(data[2]);
                col1 = Integer.parseInt(data[3]);
                col2 = Integer.parseInt(data[4]);

            } catch (NumberFormatException e) {
                return false;
            }
        }else{
            return  false;
        }

        return true;
    }
}
