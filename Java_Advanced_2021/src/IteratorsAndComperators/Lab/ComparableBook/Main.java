package IteratorsAndComperators.Lab.ComparableBook;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("The tale", 1450);
        Book book2 = new Book("Cosmos", 1978, "Carl Sagan", "Anne Druyan");

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);
    }
}
