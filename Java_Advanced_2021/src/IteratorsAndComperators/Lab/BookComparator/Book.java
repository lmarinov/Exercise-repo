package IteratorsAndComperators.Lab.BookComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        setTitle(title);
        setAuthors(authors);
        setYear(year);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<>();

        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return String.format("title: %s, year: %d, author/s: %s", this.getTitle(), this.getYear(), String.join(", ", this.getAuthors()));
    }

    @Override
    public int compareTo(Book secondBook) {
        int result = this.getTitle().compareTo(secondBook.getTitle());
        return result != 0
                ? result
                : Integer.compare(this.getYear(), secondBook.getYear());
    }
}

