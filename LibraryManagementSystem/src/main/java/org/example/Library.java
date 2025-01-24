package org.example;

import java.util.List;

public interface Library {

    String getName();
    void addBook(Book book);
    void removeBook(String title);
    boolean bookExists(String title);
    void clearAllBooks();
    void updateBookPrice(String title, double newPrice);
    Book getBookDetails(String title);
    void getBooksByAuthor(String authorName);
    void displaybooks();
}

