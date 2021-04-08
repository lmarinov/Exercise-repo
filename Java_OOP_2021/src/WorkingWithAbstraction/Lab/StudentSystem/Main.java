package WorkingWithAbstraction.Lab.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String[] input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("Exit")) {
            String commandResult = studentSystem.parseCommand(input);
            if (commandResult != null){
                System.out.println(commandResult);
            }

            input = scanner.nextLine().split("\\s+");
        }
    }
}
