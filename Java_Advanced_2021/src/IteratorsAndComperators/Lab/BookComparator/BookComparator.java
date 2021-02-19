package IteratorsAndComperators.Lab.BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        int result = o1.getTitle().compareTo(o2.getTitle());
        return result == 0
                ? Integer.compare(o1.getYear(), o2.getYear())
                : result;
    }

}
