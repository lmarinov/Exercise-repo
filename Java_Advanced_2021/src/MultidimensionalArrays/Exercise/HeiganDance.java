package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class HeiganDance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //player
        int[][] chamber = new int[15][15];
        int playerHealth = 18_500;
        int playerRow = 7;
        int playerCol = 7;
        double playerDamage = Double.parseDouble(scanner.nextLine());

        //boss
        double bossHealth = 3_000_000.0;
        String currentSpell = "";
        String previousSpell = "";
        boolean underPlague = false;

        while (playerHealth > 0 && bossHealth > 0) {
            boolean hasHit = false;
            bossHealth -= playerDamage;

            if (underPlague) {
                playerHealth -= 3500;
                underPlague = false;
            }

            if (bossHealth <= 0 || playerHealth <= 0) {
                continue;
            }

            String[] input = scanner.nextLine().split("\\s+");
            currentSpell = input[0];
            int rowHit = Integer.parseInt(input[1]);
            int colHit = Integer.parseInt(input[2]);

            if (playerRow == rowHit && colHit == playerCol) {
                hasHit = true;
            } else if (Math.abs(playerRow - rowHit) <= 1 && Math.abs(playerCol - colHit) <= 1) {
                if (playerRow - rowHit == -1 && isValid(playerRow - 1, playerCol, chamber)) {
                    playerRow--;
                } else if (playerCol - colHit == 1 && isValid(playerRow, playerCol + 1, chamber)) {
                    playerCol++;
                } else if (playerRow - rowHit == 1 && isValid(playerRow + 1, playerCol, chamber)) {
                    playerRow++;
                } else if (playerCol - colHit == -1 && isValid(playerRow, playerCol - 1, chamber)) {
                    playerCol--;
                } else {
                    hasHit = true;
                }
            }

            if (hasHit) {
                switch (currentSpell) {
                    case "Eruption":
                        previousSpell = "Eruption";
                        playerHealth -= 6000;
                        break;
                    case "Cloud":
                        previousSpell = "Plague Cloud";
                        playerHealth -= 3500;
                        underPlague = true;
                        break;
                }
            }
        }

        if (bossHealth <= 0) System.out.println("Heigan: Defeated!");
        else System.out.printf("Heigan: %.2f%n", bossHealth);

        if (playerHealth <= 0) System.out.printf("Player: Killed by %s%n", previousSpell);
        else System.out.printf("Player: %d%n", playerHealth);

        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }

    private static boolean isValid(int row, int col, int[][] chamber) {
        return row >= 0 && col >= 0 && row < chamber.length && col < chamber[row].length;
    }
}
