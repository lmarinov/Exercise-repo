package PreExam;

import java.util.Scanner;

public class RoomPainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double paintPrice = 21.50;
        double paintBuckets = Double.parseDouble(scanner.nextLine());
        double tapestryRollPrice = 5.20;
        double tapestryRolls = Double.parseDouble(scanner.nextLine());
        double gloves = Math.ceil(tapestryRolls * 0.35);
        double glovesPrice = Double.parseDouble(scanner.nextLine());
        double brushes = Math.floor(paintBuckets * 0.48);
        double brushPrice = Double.parseDouble(scanner.nextLine());

        double totalCost = ((paintPrice * paintBuckets) + (tapestryRollPrice * tapestryRolls) + (gloves * glovesPrice) + (brushes * brushPrice)) / 15;

        System.out.printf("This delivery will cost %.2f lv.", totalCost);

    }
}
