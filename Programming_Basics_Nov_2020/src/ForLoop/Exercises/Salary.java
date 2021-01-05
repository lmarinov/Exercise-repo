package ForLoop.Exercises;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int tabs = Integer.parseInt(scan.nextLine()); // nextInt()/nextDouble() only reads the next integer/double without consuming the line separator
        int salary = Integer.parseInt(scan.nextLine());// if you have a string that reads next line (nextLine()) following any of those it will take up the line separator and come up as empty string.
        int fine = 0;

        for (int i = 0; i < tabs; i++){
            String site = scan.nextLine();

            switch (site) {
                case "Facebook": fine += 150; break;
                case "Instagram": fine += 100; break;
                case "Reddit": fine += 50; break;
            }
            if (salary - fine <= 0){
                System.out.println("You have lost your salary.");
                break;
            }else if (i == tabs - 1){
                System.out.println(salary - fine);
            }
        }
    }
}
