package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class BirthdayParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Read console input for rent value
        double rent = Double.parseDouble(scanner.nextLine());

//        Calculate values for other expenses
        double cake = rent / 5;
        double drinks = cake - (cake * 45/100);
        double animator = rent/3;

//        Sum up expenses
        double expenses = rent + cake + drinks + animator;

//        Print result
        System.out.printf("%.1f", expenses);
    }
}
