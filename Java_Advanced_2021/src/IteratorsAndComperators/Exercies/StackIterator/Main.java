package IteratorsAndComperators.Exercies.StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StackIterator customStack = new StackIterator();
        String[] initialValues = scanner.nextLine().split(",\\s+");

        customStack.push(Integer.parseInt(initialValues[0].split("\\s+")[1]));

        for (int i = 1; i < initialValues.length; i++) {
            customStack.push(Integer.parseInt(initialValues[i].trim()));
        }

        String line = "";

        while (!"END".equals(line = scanner.nextLine())){
            if (line.equals("Pop")){
                try {
                    customStack.pop();
                }catch (IndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                }
            }else if(line.split("\\s+")[0].equals("Push")) {
                customStack.push(Integer.parseInt(line.split("\\s+")[1]));
            }
        }

        for (int i = 0; i < 2; i++) {
            for (Integer integer : customStack) {
                System.out.println(integer);
            }
        }
    }
}
