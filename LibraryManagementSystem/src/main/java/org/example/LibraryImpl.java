package org.example;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.ArrayList;

public class LibraryImpl implements Library {
    private String name;
    private List<Book> books = new ArrayList<>();

    public LibraryImpl(String name) {
        this.name = name;
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Library initialized: " + name);
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Library is being cleaned up");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displaybooks(){
        if(!books.isEmpty()){
            System.out.println("Library name: " + name);
            for (Book book : books){
                System.out.println(book);
            }
        }
        else{
            System.out.println("No books in the library.");
        }
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(String title) {

            if (books == null || books.isEmpty()) {
                System.out.println("No books in the library.");
                return;
            }

            boolean bookFound = books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));

            if (bookFound) {
                System.out.println("Book with title \"" + title + "\" has been removed.");
                displaybooks();

            } else {
                System.out.println("Book with title \"" + title + "\" is not present in the library.");
            }

    }

    @Override
    public boolean bookExists(String title) {

            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return true;
                }
            }
            return false;

    }

    @Override
    public void clearAllBooks() {
        books.clear();
    }

    @Override
    public void updateBookPrice(String title, double newPrice) {
        boolean bookfound = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookfound = true;
                book.setPrice(newPrice);
                System.out.println("Book price updated successfully to library" );
                displaybooks();
                break;
            }

        }
        if(!bookfound){
            System.out.println("Book is not available in the library.");
        }
    }

    @Override
    public Book getBookDetails(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void getBooksByAuthor(String authorName) {
        boolean bookfound = false;
        if (books == null || books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book book : books) {
            if (book.getAuthor().toString().equalsIgnoreCase(authorName)) {
                bookfound = true;
                System.out.println("Books by " + authorName + ":" + book.getTitle());
            }

        }
        if(!bookfound){
            System.out.println("No books found in the library by the author " + authorName);
        }
    }

}

