package NestedLoops.Exercises;

import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int letterPosition = Integer.parseInt(scanner.nextLine());

            for (int firstNum = 1; firstNum < number; firstNum++ ){
                for (int secondNum = 1; secondNum < number; secondNum++){
                    for (int thirdChar = 'a'; thirdChar < 97 + letterPosition; thirdChar++){
                        for (int fourthChar = 'a'; fourthChar < 97 + letterPosition; fourthChar++){
                            for (int fifthNum = 2; fifthNum <= number; fifthNum++){
                                if (fifthNum <= firstNum || fifthNum <= secondNum) {
                                    continue;
                                }

                                char char1 = (char) thirdChar;
                                char char2 = (char) fourthChar;

                                System.out.printf("%d%d%s%s%d ", firstNum, secondNum, char1, char2, fifthNum);
                            }
                        }
                    }
                }
            }
    }
}
