package Exam20Feb2021.P02Bomb;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static int playerRow;
    private static int playerCol;
    private static char[][] mineField;
    private static int bombsDefused = 0;
    private static boolean routeEnded = false;
    private static int bombCount;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int mineFieldSize = Integer.parseInt(scanner.nextLine());

        List<String> moveCommand = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());
        mineField = buildMatrix(mineFieldSize, scanner);

        while (!routeEnded && moveCommand.size() > 0) {
            move(moveCommand.remove(0), mineField);
        }

        if (bombsDefused == bombCount) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (routeEnded) {
            System.out.printf("END! %d bombs left on the field%n", bombCount - bombsDefused);
        }else{
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", bombCount - bombsDefused, playerRow, playerCol);
        }

    }

    private static void move(String moveCommand, char[][] mineField) {
        mineField[playerRow][playerCol] = '+';

        switch (moveCommand) {
            case "up":
                playerRow--;
                if (!validate(playerRow, playerCol, mineField)) {
                    playerRow++;
                    mineField[playerRow][playerCol] = 's';
                    return;
                }
                break;
            case "down":
                playerRow++;
                if (!validate(playerRow, playerCol, mineField)) {
                    playerRow--;
                    mineField[playerRow][playerCol] = 's';
                    return;
                }
                break;
            case "right":
                playerCol++;
                if (!validate(playerRow, playerCol, mineField)) {
                    playerCol--;
                    mineField[playerRow][playerCol] = 's';
                    return;
                }
                break;
            case "left":
                playerCol--;
                if (!validate(playerRow, playerCol, mineField)) {
                    playerCol++;
                    mineField[playerRow][playerCol] = 's';
                    return;
                }
                break;
        }


        char currentSymbol = mineField[playerRow][playerCol];
        if (currentSymbol == 'B') {
            mineField[playerRow][playerCol] = '+';
            bombsDefused++;
            System.out.println("You found a bomb!");
        } else if (currentSymbol == 'e') {
            routeEnded = true;
        }

        mineField[playerRow][playerCol] = 's';
    }

    private static boolean validate(int playerRow, int playerCol, char[][] bakery) {
        return playerRow >= 0 && playerRow < bakery.length && playerCol >= 0 && playerCol < bakery[playerRow].length;
    }

    private static char[][] buildMatrix(int mineFieldSize, Scanner scanner) {
        char[][] matrix = new char[mineFieldSize][];
        for (int row = 0; row < mineFieldSize; row++) {
            matrix[row] = String.join("", scanner.nextLine().split("\\s+")).toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 's') {
                    playerRow = row;
                    playerCol = col;
                } else if (matrix[row][col] == 'B') {
                    bombCount++;
                }
            }
        }

        return matrix;
    }
}
