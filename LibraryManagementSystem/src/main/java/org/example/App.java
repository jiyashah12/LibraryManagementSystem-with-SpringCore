package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import resources.ConfigFile;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ConfigFile.class);

        Library library1 = context.getBean(LibraryImpl.class, "Ahmedabad Central Library" );
        Author author;
        Book book;

        Scanner sc = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Book(s) to the Library");
            System.out.println("2. Remove Book from the Library");
            System.out.println("3. Display Books in the Library");
            System.out.println("4. Check if a Book Exists in the Library");
            System.out.println("5. Clear all books from the Library");
            System.out.println("6. Update the price of a book in the Library");
            System.out.println("7. Get details of a Book from the Library");
            System.out.println("8. Display all the books of an author in the Library");
            System.out.println("9. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Book Title:");
                    String title = sc.nextLine();
                    System.out.println("Enter Author Name:");
                    String authorName = sc.nextLine();
                    System.out.println("Enter Book Price:");
                    double price = sc.nextInt();

                    author = context.getBean(Author.class, authorName);
                    book = context.getBean(Book.class, title, author, price);

                    library1.addBook(book);

                    System.out.println("Book added successfully to library.");
                    break;

                case 2:
                    System.out.println("Enter Book Title to Remove:");
                    String rmvbook = sc.nextLine();

                    library1.removeBook(rmvbook);
                    break;

                case 3:
                    library1.displaybooks();
                    break;

                case 4:
                    System.out.println("Enter Book Title to Check:");
                    String bookexist = sc.nextLine();
                    boolean exists = library1.bookExists(bookexist);

                    System.out.println("Does the book " + bookexist + " exist? " + exists);
                    break;

                case 5:
                    library1.clearAllBooks();
                    System.out.println("Books in the library are removed. ");
                    break;

                case 6:
                    System.out.println("Enter which book to update and its new price:");
                    String updtbook = sc.next();
                    double np = sc.nextDouble();
                    library1.updateBookPrice(updtbook, np);
                    break;

                case 7:
                    System.out.println("Enter the title of the book to get the details:");
                    String name = sc.next();

                    if(library1.getBookDetails(name) == null){
                        System.out.println("Book is not available.");
                    }
                    else{
                        System.out.println("Details of the " + name + " book: " );
                        System.out.println(library1.getBookDetails(name));
                    }
                    break;

                case 8:
                    System.out.println("Enter the author name to find all the books: ");
                    String aname = sc.next();
                    library1.getBooksByAuthor(aname);
                    break;

                case 9:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        sc.close();
        context.close();

    }
}

