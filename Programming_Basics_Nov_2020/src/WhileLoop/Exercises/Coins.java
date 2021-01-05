package WhileLoop.Exercises;

import java.math.BigDecimal;
import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double inputMoney = Double.parseDouble(scan.nextLine());
        int coinsAmount = 0;
        inputMoney = Math.floor(inputMoney * 100);

        while (inputMoney > 0){
            if (inputMoney >= 200) {
                coinsAmount += inputMoney / 200;
                inputMoney %= 200;
            }
            else if (inputMoney >= 100){
                coinsAmount ++;
                inputMoney %= 100;
            }else if (inputMoney >= 50){
                coinsAmount ++;
                inputMoney %= 50;
            }else if (inputMoney >= 20){
                coinsAmount += inputMoney / 20;
                inputMoney %= 20;
            }else if (inputMoney >= 10){
                coinsAmount ++;
                inputMoney %= 10;
            }else if (inputMoney >= 5){
                coinsAmount ++;
                inputMoney %= 5;
            }else if (inputMoney >= 2){
                coinsAmount += inputMoney / 2;
                inputMoney %= 2;
            }else {
                coinsAmount ++;
                inputMoney --;
            }
        }

        System.out.println(coinsAmount);
    }
}
