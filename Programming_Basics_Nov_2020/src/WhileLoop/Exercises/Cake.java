package WhileLoop.Exercises;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int width  = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int totalSize = width * length;

        String command = scan.nextLine();
        int totalPiecesTaken = 0;

        while (!command.equals("STOP")){
            int piecesTaken = Integer.parseInt(command);
            totalPiecesTaken += piecesTaken;

            if (totalSize - totalPiecesTaken <= 0){
                break;
            }

            command = scan.nextLine();
        }

        if (totalPiecesTaken >= totalSize){
            System.out.printf("No more cake left! You need %d pieces more.", totalPiecesTaken - totalSize);
        }else {
            System.out.printf("%d pieces are left.", totalSize - totalPiecesTaken);
        }
    }
}
