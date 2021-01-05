package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class VacationBookList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Reading input from the console.
          int pages = Integer.parseInt(scanner.nextLine());
          int pagesPerHour = Integer.parseInt(scanner.nextLine());
          int days = Integer.parseInt(scanner.nextLine());

//        Calculating number of days needed to read a book.
           int timeToRead = (pages / pagesPerHour);
           int pagesPerDay = timeToRead / days;

//        Print result
            System.out.println(pagesPerDay);
    }
}
