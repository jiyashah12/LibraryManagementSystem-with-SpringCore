package org.example;

public class Author {
    private String authorname;

    public Author(String authorname) {
        this.authorname = authorname;
    }

    public String getAuthorname() {
        return authorname;
    }

    @Override
    public String toString() {
        return authorname ;
    }
}
