package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[][] matrix = buildMatrix(scanner);

        boolean[][] queens = findQueens(matrix);
        int[] indexes = findUnattacked(queens);

        System.out.printf("%d %d", indexes[0], indexes[1]);
    }

    private static int[] findUnattacked(boolean[][] queens) {
        int[] unattackedIndices = new int[2];

        for (int row = 0; row < queens.length; row++) {
            for (int col = 0; col < queens[0].length; col++) {
                if (queens[row][col]){
                    if (checkIfAttacked(queens, row, col)){
                        queens[row][col] = false;
                    }else{
                        unattackedIndices[0] = row;
                        unattackedIndices[1] = col;
                        return unattackedIndices;
                    }
                }
            }
        }

        unattackedIndices[0] = -1;
        unattackedIndices[1] = -1;

        return unattackedIndices;
    }

    private static boolean checkIfAttacked(boolean[][] queens, int row, int col) {
        // check if attacked from above
        if(isInBounds(queens, row - 1, col)){
            for (int r = row - 1; r >= 0; r--) {
                if (queens[r][col]) return true;
            }
        }
        // check if attacked from below
        if(isInBounds(queens, row + 1, col)){
            for (int r = row + 1; r < queens.length; r++) {
                if (queens[r][col]) return true;
            }
        }
        // check if attacked from the right
        if(isInBounds(queens, row, col + 1)){
            for (int c = col + 1; c < queens[0].length; c++) {
                if (queens[row][c]) return true;
            }
        }
        // check if attacked from the left
        if(isInBounds(queens, row, col - 1)){
            for (int c = col - 1; c >= 0; c--) {
                if (queens[row][c]) return true;
            }
        }
        // check if attacked from right top diagonal
        if(isInBounds(queens, row - 1, col + 1)){
            int r = row - 1;
            int c = col + 1;
            while (r >= 0 && c < queens[0].length){
                if (queens[r][c]) return true;
                r--;
                c++;
            }
        }
        // check if attacked from right bottom diagonal
        if(isInBounds(queens, row + 1, col + 1)){
            int r = row + 1;
            int c = col + 1;
            while (r < queens.length && c < queens[0].length){
                if (queens[r][c]) return true;
                r++;
                c++;
            }
        }
        // check if attacked from left top diagonal
        if(isInBounds(queens, row - 1, col - 1)){
            int r = row - 1;
            int c = col - 1;
            while (r >= 0 && c >= 0){
                if (queens[r][c]) return true;
                r--;
                c--;
            }
        }
        // check if attacked from left bottom diagonal
        if(isInBounds(queens, row + 1, col - 1)){
            int r = row + 1;
            int c = col - 1;
            while (r < queens.length && c >= 0){
                if (queens[r][c]) return true;
                r++;
                c--;
            }
        }

        return false;
    }

    private static boolean isInBounds(boolean[][] queens, int row, int col) {
        return row < queens.length && row >= 0 && col <  queens[row].length && col >=0;
    }

    private static boolean[][] findQueens(char[][] matrix) {
        boolean[][] positions = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                positions[row][col] = matrix[row][col] == 'q';
            }
        }

        return positions;
    }

    private static char[][] buildMatrix(Scanner scanner) {
        int n = 8;

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = getIntArray(scanner);
        }
        return matrix;
    }

    private static char[] getIntArray(Scanner scanner) {
        return scanner.nextLine().replace(" ", "").toCharArray();
    }
}
