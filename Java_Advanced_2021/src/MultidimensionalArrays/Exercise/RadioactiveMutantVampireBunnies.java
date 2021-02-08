package MultidimensionalArrays.Exercise;

import java.util.*;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] matrix = buildLair(scanner);
        chaseSequence(matrix, scanner);
    }

    private static void chaseSequence(char[][] matrix, Scanner scanner) {
        int playerRow = -1;
        int playerCol = -1;
        boolean isOut = false;
        for (int i = 0; i < matrix.length; i++) {
            if (String.valueOf(matrix[i]).contains("P")){
                playerCol = String.valueOf(matrix[i]).indexOf("P");
                playerRow = i;
            }
        }

        char[] input = scanner.nextLine().toCharArray();

        for (char character : input) {
            switch (character){
                case 'R':
                    if (!isValid(playerRow, playerCol + 1, matrix)){
                        isOut = true;
                        matrix[playerRow][playerCol] = '.';
                    }else if(matrix[playerRow][playerCol + 1] == 'B'){
                        matrix[playerRow][playerCol] = '.';
                        playerCol++;
                    }else{
                        matrix[playerRow][playerCol + 1] = 'P';
                        matrix[playerRow][playerCol] = '.';
                        playerCol++;
                    }
                    break;
                case 'L':
                    if (!isValid(playerRow, playerCol - 1, matrix)){
                        isOut = true;
                        matrix[playerRow][playerCol] = '.';
                    }else if(matrix[playerRow][playerCol - 1] == 'B'){
                        matrix[playerRow][playerCol] = '.';
                        playerCol--;
                    }else{
                        matrix[playerRow][playerCol - 1] = 'P';
                        matrix[playerRow][playerCol] = '.';
                        playerCol--;
                    }
                    break;
                case 'U':
                    if (!isValid(playerRow - 1, playerCol, matrix)){
                        isOut = true;
                        matrix[playerRow][playerCol] = '.';
                    }else if(matrix[playerRow - 1][playerCol] == 'B'){
                        matrix[playerRow][playerCol] = '.';
                        playerRow--;
                    }else{
                        matrix[playerRow - 1][playerCol] = 'P';
                        matrix[playerRow][playerCol] = '.';
                        playerRow--;
                    }
                    break;
                case 'D':
                    if (!isValid(playerRow + 1, playerCol, matrix)){
                        isOut = true;
                        matrix[playerRow][playerCol] = '.';
                    }else if(matrix[playerRow + 1][playerCol] == 'B'){
                        matrix[playerRow][playerCol] = '.';
                        playerRow++;
                    }else{
                        matrix[playerRow + 1][playerCol] = 'P';
                        matrix[playerRow][playerCol] = '.';
                        playerRow++;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Cannot recognize command " + character);
            }

            matrix = bunnyMultiplicator(matrix);

            boolean playerIsAlive =  Arrays.stream(Arrays.stream(matrix)
                    .filter(e -> String.valueOf(e).contains("P"))
                    .toArray(char[][]::new))
                    .anyMatch(Objects::nonNull);

            if (!playerIsAlive) break;
        }


        printMatrix(matrix);

        if (isOut){
            System.out.printf("won: %d %d", playerRow, playerCol);
        }else{
            System.out.printf("dead: %d %d", playerRow, playerCol);
        }


    }

    private static char[][] bunnyMultiplicator(char[][] matrix) {

        char[][] tempMatrix = Arrays.stream(matrix).map(char[]::clone).toArray(char[][]::new);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B'){
                    if (isValid(row + 1, col, matrix) && tempMatrix[row + 1][col] != 'B'){
                        tempMatrix[row + 1][col] = 'B';
                    }
                    if(isValid(row - 1, col, matrix) && tempMatrix[row - 1][col] != 'B'){
                        tempMatrix[row - 1][col] = 'B';
                    }
                    if(isValid(row, col + 1, matrix) && tempMatrix[row][col + 1] != 'B'){
                        tempMatrix[row][col + 1] = 'B';
                    }
                    if(isValid(row, col - 1, matrix) && tempMatrix[row][col - 1] != 'B'){
                        tempMatrix[row][col - 1] = 'B';
                    }
                }
            }
        }

        return tempMatrix;
    }

    private static char[][] buildLair(Scanner scanner) {
        String[] tokens = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] characters = scanner.nextLine().toCharArray();
            if (cols >= 0) System.arraycopy(characters, 0, matrix[row], 0, cols);
        }

        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).forEach(System.out::println);
    }

    private static boolean isValid(int row, int col, char[][] chamber) {
        return row >= 0 && col >= 0 && row < chamber.length && col < chamber[row].length;
    }
}
