package resources;

import org.example.Author;
import org.example.Book;
import org.example.Library;
import org.example.LibraryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigFile {

    @Bean
    @Scope("prototype")
    public Author authObj1(String authorname){
        return new Author(authorname);
    }

    @Bean
    @Scope("prototype")
    public Book bookObj1(String title, Author author, double price){
        return new Book(title, author, price) ;
    }

    @Bean
    @Scope("prototype")
    public LibraryImpl libObj1(String name){
        return new LibraryImpl(name);

    }
}
