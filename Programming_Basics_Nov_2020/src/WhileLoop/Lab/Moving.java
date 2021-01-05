package WhileLoop.Lab;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());
        int width = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());

        int space = length * width * height;
        int totalCargo = 0;

        String command = scan.nextLine();

        while (!command.equals("Done")){
            int input = Integer.parseInt(command);
            totalCargo += input;

            if (space < totalCargo){
                System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(totalCargo - space));
                break;
            }

            command = scan.nextLine();
        }

        if (space >= totalCargo) {
            System.out.printf("%d Cubic meters left.", space - totalCargo);
        }
    }
}
