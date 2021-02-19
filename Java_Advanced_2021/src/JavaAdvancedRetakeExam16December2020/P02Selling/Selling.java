package JavaAdvancedRetakeExam16December2020.P02Selling;

import java.util.Scanner;

public class Selling {
    private static int playerRow;
    private static int playerCol;
    private static int money = 0;
    private static char[][] bakery;
    private static boolean bakerIsBaking = true;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int bakerySize = Integer.parseInt(scanner.nextLine());

        bakery = buildMatrix(bakerySize, scanner);

        while (bakerIsBaking && money < 50){
            String moveCommand = scanner.nextLine();

            move(moveCommand, bakery);
        }

        if (!bakerIsBaking){
            System.out.println("Bad news, you are out of the bakery.");
        }

        if (money >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n", money);
        printMatrix(bakery);
    }

    private static void printMatrix(char[][] bakery) {
        for (int row = 0; row < bakery.length; row++) {
            System.out.println(String.valueOf(bakery[row]));
        }
    }

    private static void move(String moveCommand, char[][] bakery) {
        bakery[playerRow][playerCol] = '-';

        switch (moveCommand){
            case "up":
                playerRow--;
                break;
            case "down":
                playerRow++;
                break;
            case "right":
                playerCol++;
                break;
            case "left":
                playerCol--;
                break;
        }

        if (!validate(playerRow, playerCol, bakery)){
            bakerIsBaking = false;
            return;
        }

        char currentSymbol = bakery[playerRow][playerCol];
        if (currentSymbol == 'O'){
            bakery[playerRow][playerCol] = '-';
            for (int row = 0; row < bakery.length; row++) {
                for (int col = 0; col < bakery[row].length; col++) {
                    if (bakery[row][col] == 'O'){
                        playerRow = row;
                        playerCol = col;
                    }
                }
            }
        }else if(String.valueOf(currentSymbol).matches("\\d+")){
            money += Integer.parseInt(String.valueOf(currentSymbol));
        }

        bakery[playerRow][playerCol] = 'S';

    }

    private static boolean validate(int playerRow, int playerCol, char[][] bakery) {
        return playerRow >= 0 && playerRow < bakery.length && playerCol >= 0 && playerCol < bakery[playerRow].length;
    }

    private static char[][] buildMatrix(int bakerySize, Scanner scanner) {
        char[][] matrix = new char[bakerySize][];
        for (int row = 0; row < bakerySize; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S'){
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        return matrix;
    }
}
