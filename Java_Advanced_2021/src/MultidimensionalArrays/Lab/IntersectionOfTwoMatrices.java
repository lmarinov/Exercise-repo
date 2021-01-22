package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());

        String[][] matrix1 = buildMatrix(scanner, row, col);
        String[][] matrix2 = buildMatrix(scanner, row, col);

        String[][] intersectingMatrix = findIntersecting(matrix1, matrix2);
        printMatrix(intersectingMatrix);
    }

    private static void printMatrix(String[][] intersectingMatrix) {
        for (String[] el : intersectingMatrix){
            System.out.println(String.join(" ", el));
        }
    }

    private static String[][] findIntersecting(String[][] matrix1, String[][] matrix2) {
        String[][]matrix = new String[matrix1.length][matrix1[0].length];
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                    matrix[row][col] = matrix1[row][col].equals(matrix2[row][col])
                            ? matrix1[row][col] : "*";
            }
        }
        return matrix;
    }

    private static String[][] buildMatrix(Scanner scanner, int row, int col) {
        String[][] matrix = new String[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = getStrArray(scanner);
        }
        return matrix;
    }

    private static String[] getStrArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
