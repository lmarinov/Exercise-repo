package PreExam;

import java.util.Scanner;

public class PuppyCare {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int foodProvided = Integer.parseInt(scan.nextLine()) * 1000;
        boolean isEnough = true;

        String command = scan.nextLine();

        while (!command.equals("Adopted")){
            int puppyConsumption =  Integer.parseInt(command);
            foodProvided -= puppyConsumption;

            if (foodProvided < 0){
                isEnough = false;
            }

            command = scan.nextLine();
        }

        if (isEnough) System.out.printf("Food is enough! Leftovers: %d grams.", foodProvided);
        else System.out.printf("Food is not enough. You need %d grams more.", Math.abs(foodProvided));
    }
}
