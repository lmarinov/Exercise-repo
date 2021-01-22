package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = buildMatrix(scanner);

        int[][] secondMatrix = buildMatrix(scanner);

        System.out.println(areEqual(firstMatrix, secondMatrix));
    }

    private static int[][] buildMatrix(Scanner scanner) {
        int[] tokens = getIntArray(scanner);
        int row = tokens[0];
        int col = tokens[1];

        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = getIntArray(scanner);
        }
        return matrix;
    }

    private static int[] getIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String areEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length == secondMatrix.length){
            for (int row = 0; row < firstMatrix.length; row++) {
                if(firstMatrix[row].length == secondMatrix[row].length){
                    for (int col = 0; col < firstMatrix[row].length; col++) {
                        if(firstMatrix[row][col] != secondMatrix[row][col]){
                            return "not equal";
                        }
                    }
                }else{
                    return "not equal";
                }
            }

            return "equal";
        }

        return "not equal";
    }
}
