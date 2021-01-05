package WhileLoop.Exercises;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String bookTitle = scan.nextLine();

        boolean bookFound = false;
        int bookCount = 0;

        String bookChecked = scan.nextLine();
        while (!bookChecked.equals("No More Books")){
            if (bookTitle.equals(bookChecked)){
                bookFound = true;
                break;
            }else {
                bookCount++;
                bookChecked = scan.nextLine();
            }
        }

        if(bookFound) System.out.printf("You checked %d books and found it.", bookCount);
        else System.out.printf("The book you search is not here!%nYou checked %d books.", bookCount);
    }
}
