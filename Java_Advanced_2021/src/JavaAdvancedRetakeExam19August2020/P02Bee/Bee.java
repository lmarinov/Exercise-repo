package JavaAdvancedRetakeExam19August2020.P02Bee;

import java.util.Scanner;

public class Bee {
    private static int beeRow;
    private static int beeCol;
    private static boolean beeIsInTerritory = true;
    private static char[][] beeTerritory;
    private static int pollinatedFlowers = 0;

    public static void main(String[] args) {

         Scanner scanner = new Scanner(System.in);
         int beeTerritorySize = Integer.parseInt(scanner.nextLine());
         beeTerritory = buildMatrix(beeTerritorySize, scanner);
         String command = "";

         while (beeIsInTerritory && !"End".equals(command = scanner.nextLine())){
             moveBee(command);
         }

         if (!beeIsInTerritory){
             System.out.println("The bee got lost!");
         }

         if (pollinatedFlowers < 5){
             System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
         }else{
             System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
         }

         printMatrix(beeTerritory);
    }

    private static void printMatrix(char[][] beeTerritory) {
        for (int row = 0; row < beeTerritory.length; row++) {
            System.out.println(beeTerritory[row]);
        }
    }

    private static void moveBee(String command) {
        beeTerritory[beeRow][beeCol] = '.';

        switch (command){
            case "up":
                beeRow--;
                break;
            case "down":
                beeRow++;
                break;
            case "right":
                beeCol++;
                break;
            case "left":
                beeCol--;
                break;
        }

        if (!validate(beeRow, beeCol)){
            beeIsInTerritory = false;
            return;
        }

        char currentSymbol = beeTerritory[beeRow][beeCol];
        if (currentSymbol == 'f'){
            pollinatedFlowers++;
        }else if(currentSymbol == 'O'){
            beeTerritory[beeRow][beeCol] = '.';
            moveBee(command);
        }

        beeTerritory[beeRow][beeCol] = 'B';
    }

    private static boolean validate(int beeRow, int beeCol) {
        return beeRow >= 0 && beeRow < beeTerritory.length && beeCol >= 0 && beeCol < beeTerritory[beeRow].length;
    }

    private static char[][] buildMatrix(int beeTerritorySize, Scanner scanner) {
        char[][] matrix = new char[beeTerritorySize][];
        for (int row = 0; row < beeTerritorySize; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B'){
                    beeRow = row;
                    beeCol = col;
                }
            }
        }
        return matrix;
    }
}
